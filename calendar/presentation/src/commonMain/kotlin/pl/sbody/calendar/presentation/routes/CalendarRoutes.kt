package pl.sbody.calendar.presentation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class CalendarRoutes {
    @Serializable data object CalendarScreen : CalendarRoutes()

    @Serializable data class SlotDetails(val id: Int) : CalendarRoutes()
}
