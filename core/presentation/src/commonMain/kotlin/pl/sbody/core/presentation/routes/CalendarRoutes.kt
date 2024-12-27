package pl.sbody.core.presentation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class CalendarRoutes {
    @Serializable
    data object CalendarScreens : CalendarRoutes() {
        @Serializable data object CalendarScreen : CalendarRoutes()
    }
}
