package pl.sbody.calendar.presentation.events

import kotlinx.datetime.LocalDate

sealed class CalendarWidgetEvents {
    data class PickDate(val pickedDate: LocalDate) : CalendarWidgetEvents()
}
