package pl.sbody.core.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import pl.sbody.core.presentation.composables.ProfilePicture
import pl.sbody.core.presentation.models.UserSummary
import pl.sbody.core.presentation.res.Res
import pl.sbody.core.presentation.res.balance
import pl.sbody.core.presentation.res.navigate_back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userSummary: UserSummary,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(Res.string.navigate_back)) },
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
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ProfilePicture(
                modifier = Modifier.size(100.dp).clip(CircleShape),
                url = userSummary.photoUrl,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = userSummary.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = userSummary.surname, style = MaterialTheme.typography.headlineLarge)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = stringResource(Res.string.balance) + ":",
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = userSummary.balance.toString(),
                    style = MaterialTheme.typography.displaySmall,
                )
            }
        }
    }
}
