package pl.sbody.calendar.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import pl.sbody.calendar.presentation.models.UsersTrainingSlot
import pl.sbody.calendar.presentation.res.Res
import pl.sbody.calendar.presentation.res.coach
import pl.sbody.calendar.presentation.res.duration
import pl.sbody.calendar.presentation.res.note
import pl.sbody.calendar.presentation.res.price
import pl.sbody.calendar.presentation.res.slot_description
import pl.sbody.core.presentation.util.priceAsString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlotDetailsScreen(
    slot: UsersTrainingSlot,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(slot.type.name) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Sharp.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = stringResource(Res.string.coach) + ":",
                    style = MaterialTheme.typography.headlineMedium,
                )
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = slot.coach.name,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = slot.coach.surname,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                Text(
                    text = stringResource(Res.string.slot_description) + ":",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = slot.type.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = stringResource(Res.string.duration) + ":",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = slot.length.toString() + "min",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = stringResource(Res.string.note) + ":",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = slot.note,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = stringResource(Res.string.price) + ":",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = slot.price.priceAsString(),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}
