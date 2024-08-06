package pl.sbody.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pl.sbody.auth.presentation.events.LoginScreenEvents
import pl.sbody.auth.presentation.states.LoginScreenState

class LoginViewModel : ViewModel() {

    private val _loginState = MutableStateFlow<LoginScreenState>(LoginScreenState())
    val loginState = _loginState.asStateFlow()

    fun onEvent(loginScreenEvents: LoginScreenEvents) {
        when (loginScreenEvents) {
            LoginScreenEvents.Submit -> TODO("Implement login functionality")
            is LoginScreenEvents.UpdateEmail -> {
                _loginState.value = _loginState.value.copy(email = loginScreenEvents.email)
            }
            is LoginScreenEvents.UpdatePassword -> {
                _loginState.value = _loginState.value.copy(password = loginScreenEvents.password)
            }
        }
    }
}
