package pl.sbody.calendar.presentation.graphs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.kizitonwose.calendar.core.now
import com.kizitonwose.calendar.core.plusDays
import com.kizitonwose.calendar.core.plusMonths
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import pl.sbody.calendar.domain.models.Coach
import pl.sbody.calendar.domain.models.SlotType
import pl.sbody.calendar.presentation.events.CalendarWidgetEvents
import pl.sbody.calendar.presentation.models.UsersTrainingSlot
import pl.sbody.calendar.presentation.screens.CalendarScreen
import pl.sbody.calendar.presentation.screens.SlotDetailsScreen
import pl.sbody.calendar.presentation.states.CalendarWidgetState
import pl.sbody.core.presentation.routes.CalendarRoutes

val exampleUsersTrainingSlots =
    listOf(
        UsersTrainingSlot(
            id = 1,
            coach = Coach(1, "John", "Doe"),
            startDateTime = LocalDateTime(date = LocalDate.now().plusDays(1), LocalTime(10, 10)),
            length = 60,
            note = "Beginner session",
            status = 1,
            price = 370.0F,
            paid = 0,
            type = SlotType(1, "Individual", "One-on-one session"),
            occurred = false,
        ),
        UsersTrainingSlot(
            id = 2,
            coach = Coach(2, "Jane", "Smith"),
            startDateTime = LocalDateTime(date = LocalDate.now().plusDays(2), LocalTime(10, 10)),
            length = 90,
            note = "Advanced techniques",
            status = 2,
            price = 270.0F,
            paid = 1,
            type = SlotType(2, "Group", "Small group session"),
            occurred = true,
        ),
        UsersTrainingSlot(
            id = 3,
            coach = Coach(1, "John", "Doe"),
            startDateTime = LocalDateTime(date = LocalDate.now(), LocalTime(10, 10)),
            length = 60,
            note = "",
            status = 3,
            price = 170.0F,
            paid = 0,
            type = SlotType(1, "Individual", "One-on-one session"),
            occurred = false,
        ),
        UsersTrainingSlot(
            id = 4,
            coach = Coach(1, "John", "Doe"),
            startDateTime = LocalDateTime(date = LocalDate.now(), LocalTime(10, 10)),
            length = 60,
            note = "",
            status = 3,
            price = 170.0F,
            paid = 0,
            type = SlotType(1, "Individual", "One-on-one session"),
            occurred = false,
        ),
        UsersTrainingSlot(
            id = 1,
            coach = Coach(1, "John", "Doe"),
            startDateTime = LocalDateTime(date = LocalDate.now().plusMonths(1), LocalTime(10, 10)),
            length = 60,
            note = "Beginner session",
            status = 1,
            price = 370.0F,
            paid = 0,
            type = SlotType(1, "Individual", "One-on-one session"),
            occurred = false,
        ),
    )

fun NavGraphBuilder.calendarGraph(navController: NavHostController) {
    navigation<CalendarRoutes.CalendarScreens>(startDestination = CalendarRoutes.CalendarScreens.CalendarScreen) {
        composable<CalendarRoutes.CalendarScreens.SlotDetailsScreen> {
            SlotDetailsScreen(
                slot = exampleUsersTrainingSlots[0],
                navigateBack = { navController.navigateUp() },
            )
        }

        composable<CalendarRoutes.CalendarScreens.CalendarScreen> {
            var test by remember {
                mutableStateOf(CalendarWidgetState(usersTrainingSlots = exampleUsersTrainingSlots))
            }

            CalendarScreen(
                calendarWidgetState = test,
                checkLocalDate = { localDate: LocalDate ->
                    exampleUsersTrainingSlots.map { it.startDateTime.date }.contains(localDate)
                },
                onCalendarWidgetEvent = { event: CalendarWidgetEvents ->
                    when (event) {
                        is CalendarWidgetEvents.PickDate -> {
                            test = test.copy(pickedDate = event.pickedDate)
                        }
                    }
                },
                pickedDaySlots =
                test.usersTrainingSlots.filter { usersTrainingSlot: UsersTrainingSlot ->
                    usersTrainingSlot.startDateTime.date.compareTo(test.pickedDate) == 0
                },
                navigateToDetails = { navController.navigate(CalendarRoutes.CalendarScreens.SlotDetailsScreen) },
            )
        }
    }
}
