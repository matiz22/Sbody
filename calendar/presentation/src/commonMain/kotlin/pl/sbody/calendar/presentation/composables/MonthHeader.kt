package pl.sbody.calendar.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.core.CalendarMonth

@Composable
fun MonthHeader(
    calendarMonth: CalendarMonth,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = calendarMonth.yearMonth.month.name,
            style = MaterialTheme.typography.headlineSmall,
            color = color,
        )
        Text(
            text = calendarMonth.yearMonth.year.toString(),
            style = MaterialTheme.typography.headlineSmall,
            color = color,
        )
    }
}
