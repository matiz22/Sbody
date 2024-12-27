package pl.sbody.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.sbody.auth.presentation.events.LoginScreenEvents
import pl.sbody.auth.presentation.states.LoginScreenState

class LoginViewModel : ViewModel() {

    private val _loginState = MutableStateFlow<LoginScreenState>(LoginScreenState())
    val loginState = _loginState.asStateFlow()

    private val _navigationChannel = Channel<Boolean>()
    val navigationChannel = _navigationChannel.receiveAsFlow()

    fun onEvent(loginScreenEvents: LoginScreenEvents) {
        when (loginScreenEvents) {
            LoginScreenEvents.Submit -> {
                viewModelScope.launch {
                    withContext(Dispatchers.Main.immediate) {
                        _navigationChannel.send(true)
                    }
                }
            }

            is LoginScreenEvents.UpdateEmail -> {
                _loginState.value = _loginState.value.copy(email = loginScreenEvents.email)
            }

            is LoginScreenEvents.UpdatePassword -> {
                _loginState.value = _loginState.value.copy(password = loginScreenEvents.password)
            }
        }
    }
}
