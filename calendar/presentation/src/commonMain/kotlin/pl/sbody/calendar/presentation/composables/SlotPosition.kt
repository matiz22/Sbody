package pl.sbody.calendar.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.sbody.calendar.presentation.models.UsersTrainingSlot

@Composable
fun SlotPosition(
    slot: UsersTrainingSlot,
    navigateToDetails: () -> Unit,
    modifier: Modifier = Modifier.sizeIn(minWidth = 300.dp, maxWidth = 400.dp),
) {
    Card(modifier = modifier, onClick = navigateToDetails) {
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(text = slot.type.name, style = MaterialTheme.typography.headlineSmall)
                Text(text = slot.type.description, style = MaterialTheme.typography.bodySmall)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = slot.startDateTime.time.toString())
                Icon(imageVector = Icons.AutoMirrored.Sharp.ArrowForward, contentDescription = null)
            }
        }
    }
}
