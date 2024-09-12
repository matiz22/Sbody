package pl.sbody.calendar.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition

@Suppress("ktlint:compose:modifier-missing-check")
@Composable
fun DayItem(
    calendarDay: CalendarDay,
    containsEvent: Boolean = false,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    Box(
        modifier =
        Modifier.aspectRatio(1f)
            .padding(2.dp)
            .then(
                if (selected) {
                    Modifier.background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = CircleShape,
                    )
                } else {
                    Modifier
                },
            )
            .clip(CircleShape)
            .then(
                if (containsEvent && calendarDay.position == DayPosition.MonthDate) {
                    Modifier.clickable(onClick = onClick)
                } else {
                    Modifier
                },
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = calendarDay.date.dayOfMonth.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color =
            if (selected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else if (calendarDay.position != DayPosition.MonthDate) {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            } else {
                MaterialTheme.colorScheme.onSurface
            },
        )
        if (containsEvent) {
            Box(
                modifier = Modifier.fillMaxSize().padding(bottom = 2.dp),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Box(
                    modifier =
                    Modifier.size(4.dp)
                        .clip(CircleShape)
                        .then(
                            if (selected) {
                                Modifier.background(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    shape = CircleShape,
                                )
                            } else {
                                Modifier.background(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    shape = CircleShape,
                                )
                            },
                        ),
                )
            }
        }
    }
}
