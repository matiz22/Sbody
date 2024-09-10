package pl.sbody.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import pl.sbody.auth.presentation.events.LoginScreenEvents
import pl.sbody.auth.presentation.res.Res
import pl.sbody.auth.presentation.res.log_in
import pl.sbody.auth.presentation.states.LoginScreenState
import pl.sbody.core.presentation.composables.AppLogo
import pl.sbody.core.presentation.composables.InputField

@Composable
fun LoginScreen(
    loginScreenState: LoginScreenState,
    onEvent: (LoginScreenEvents) -> Unit,
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    val focusManager = LocalFocusManager.current
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AppLogo(modifier = Modifier.size(200.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                InputField(
                    modifier = Modifier.width(500.dp).padding(horizontal = 16.dp),
                    value = loginScreenState.email,
                    onValueChange = { newValue ->
                        onEvent(LoginScreenEvents.UpdateEmail(newValue))
                    },
                    valueError = loginScreenState.emailError,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions =
                    KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                    enabled = loginScreenState.emailEnabled,
                )
                InputField(
                    modifier = Modifier.width(500.dp).padding(horizontal = 16.dp),
                    value = loginScreenState.password,
                    onValueChange = { newValue ->
                        onEvent(LoginScreenEvents.UpdatePassword(newValue))
                    },
                    valueError = loginScreenState.passwordError,
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions =
                    KeyboardActions(
                        onNext = { onEvent(LoginScreenEvents.Submit) },
                    ),
                    enabled = loginScreenState.passwordEnabled,
                )
            }
            Button(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                onClick = { onEvent(LoginScreenEvents.Submit) },
                content = {
                    Text(
                        text = stringResource(Res.string.log_in),
                        style = MaterialTheme.typography.displaySmall,
                    )
                },
                enabled = loginScreenState.submitButtonEnabled,
            )
        }
    }
}
