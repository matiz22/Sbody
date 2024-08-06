package pl.sbody.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import pl.sbody.auth.presentation.res.Res
import pl.sbody.auth.presentation.res.log_in
import pl.sbody.auth.presentation.res.register
import pl.sbody.core.presentation.composables.AppLogo

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                AppLogo(modifier = Modifier.size(400.dp))
            }

            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onLoginClick,
                    content = {
                        Text(
                            text = stringResource(Res.string.log_in),
                            style = MaterialTheme.typography.displaySmall,
                        )
                    },
                )

                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onRegisterClick,
                    content = {
                        Text(
                            text = stringResource(Res.string.register),
                            style = MaterialTheme.typography.displaySmall,
                        )
                    },
                )
            }
        }
    }
}
