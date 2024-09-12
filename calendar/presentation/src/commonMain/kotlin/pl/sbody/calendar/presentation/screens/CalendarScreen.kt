package pl.sbody.calendar.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
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
import pl.sbody.calendar.presentation.states.CalendarWidgetState
import sbody.calendar.presentation.generated.resources.Res
import sbody.calendar.presentation.generated.resources.user_slots

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    calendarWidgetState: CalendarWidgetState,
    pickedDaySlots: List<UsersTrainingSlot>,
    onCalendarWidgetEvent: (CalendarWidgetEvents) -> Unit,
    navigateToDetails: (Int) -> Unit,
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
