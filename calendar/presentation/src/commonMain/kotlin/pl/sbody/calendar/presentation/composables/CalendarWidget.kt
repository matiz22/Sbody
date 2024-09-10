package pl.sbody.calendar.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.minusMonths
import com.kizitonwose.calendar.core.plusMonths
import com.kizitonwose.calendar.core.yearMonth
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import pl.sbody.calendar.presentation.events.CalendarWidgetEvents
import pl.sbody.calendar.presentation.states.CalendarWidgetState

@Composable
fun CalendarWidget(
    calendarWidgetState: CalendarWidgetState,
    onCalendarWidgetEvent: (CalendarWidgetEvents) -> Unit,
    modifier: Modifier = Modifier.padding(8.dp),
    checkAvailability: (LocalDate) -> Boolean,
) {
    val calendarState =
        rememberCalendarState(
            startMonth = calendarWidgetState.pickedDate.yearMonth,
            endMonth = calendarWidgetState.pickedDate.yearMonth.plusMonths(1),
        )
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = modifier,
    ) {
        Box(contentAlignment = Alignment.Center) {
            HorizontalCalendar(
                modifier = Modifier.animateContentSize(animationSpec = tween(1000)),
                state = calendarState,
                monthHeader = { calendarMonth ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    calendarState.animateScrollToMonth(
                                        calendarState.firstVisibleMonth.yearMonth.minusMonths(1),
                                    )
                                }
                            },
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = null,
                            )
                        }
                        MonthHeader(calendarMonth)
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    calendarState.animateScrollToMonth(
                                        calendarState.firstVisibleMonth.yearMonth.plusMonths(1),
                                    )
                                }
                            },
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                                contentDescription = null,
                            )
                        }
                    }
                },
                dayContent = { calendarDay ->
                    DayItem(
                        selected = calendarDay.date.compareTo(calendarWidgetState.pickedDate) == 0,
                        containsEvent = checkAvailability(calendarDay.date),
                        calendarDay = calendarDay,
                        onClick = {
                            onCalendarWidgetEvent(CalendarWidgetEvents.PickDate(calendarDay.date))
                        },
                    )
                },
            )
        }
    }
}
