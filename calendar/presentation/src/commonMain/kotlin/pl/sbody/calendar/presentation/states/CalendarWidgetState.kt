package pl.sbody.calendar.presentation.states

import com.kizitonwose.calendar.core.now
import kotlinx.datetime.LocalDate
import pl.sbody.calendar.presentation.models.UsersTrainingSlot

data class CalendarWidgetState(
    val pickedDate: LocalDate = LocalDate.now(),
    val usersTrainingSlots: List<UsersTrainingSlot> = emptyList(),
)
