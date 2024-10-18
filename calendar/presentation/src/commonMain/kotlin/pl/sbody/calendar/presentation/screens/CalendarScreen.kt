package pl.sbody.calendar.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.stringResource
import pl.sbody.calendar.presentation.composables.CalendarWidget
import pl.sbody.calendar.presentation.composables.SlotPosition
import pl.sbody.calendar.presentation.events.CalendarWidgetEvents
import pl.sbody.calendar.presentation.models.UsersTrainingSlot
import pl.sbody.calendar.presentation.res.Res
import pl.sbody.calendar.presentation.res.user_slots
import pl.sbody.calendar.presentation.states.CalendarWidgetState
import pl.sbody.core.presentation.composables.ProfilePicture
import pl.sbody.core.presentation.models.UserSummary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    calendarWidgetState: CalendarWidgetState,
    pickedDaySlots: List<UsersTrainingSlot>,
    userSummary: UserSummary,
    onCalendarWidgetEvent: (CalendarWidgetEvents) -> Unit,
    navigateToDetails: (Int) -> Unit,
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier.fillMaxSize(),
    checkLocalDate: (LocalDate) -> Boolean,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(Res.string.user_slots))
                },
                actions = {
                    IconButton(onClick = navigateToProfile) {
                        ProfilePicture(url = userSummary.photoUrl)
                    }
                },
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentPadding = PaddingValues(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                CalendarWidget(
                    calendarWidgetState = calendarWidgetState,
                    onCalendarWidgetEvent = onCalendarWidgetEvent,
                    checkAvailability = checkLocalDate,
                )
            }
            item {
                Text(
                    text = calendarWidgetState.pickedDate.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            items(pickedDaySlots) { slot ->
                SlotPosition(slot = slot, navigateToDetails = { navigateToDetails(slot.id) })
            }
        }
    }
}
