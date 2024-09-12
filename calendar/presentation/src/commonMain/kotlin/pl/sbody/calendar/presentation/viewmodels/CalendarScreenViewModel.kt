package pl.sbody.calendar.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.LocalDate
import pl.sbody.calendar.presentation.events.CalendarWidgetEvents
import pl.sbody.calendar.presentation.states.CalendarWidgetState

class CalendarScreenViewModel : ViewModel() {
    private val calendarWidgetState = MutableStateFlow(CalendarWidgetState())
    private val availableDates: StateFlow<List<LocalDate>> =
        calendarWidgetState
            .map { state ->
                state.usersTrainingSlots.map { usersTrainingSlot ->
                    usersTrainingSlot.startDateTime.date
                }
            }
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val pickedDaySlots =
        calendarWidgetState
            .map { state ->
                state.usersTrainingSlots.filter { slot ->
                    availableDates.value.contains(slot.startDateTime.date)
                }
            }
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun onCalendarWidgetEvent(calendarWidgetEvent: CalendarWidgetEvents) {
        when (calendarWidgetEvent) {
            is CalendarWidgetEvents.PickDate -> {
                calendarWidgetState.value =
                    calendarWidgetState.value.copy(pickedDate = calendarWidgetEvent.pickedDate)
            }
        }
    }

    fun checkLocalDate(localDate: LocalDate): Boolean = availableDates.value.contains(localDate)
}
