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
import pl.sbody.auth.presentation.events.RegisterScreenEvents
import pl.sbody.auth.presentation.states.RegisterScreenState

class RegisterViewModel : ViewModel() {

    private val _registerState = MutableStateFlow<RegisterScreenState>(RegisterScreenState())
    val registerState = _registerState.asStateFlow()

    private val _navigationChannel = Channel<Boolean>()
    val navigationChannel = _navigationChannel.receiveAsFlow()

    fun onEvent(loginScreenEvents: RegisterScreenEvents) {
        when (loginScreenEvents) {
            RegisterScreenEvents.Submit -> {
                viewModelScope.launch {
                    withContext(Dispatchers.Main.immediate) {
                        _navigationChannel.send(true)
                    }
                }
            }

            is RegisterScreenEvents.UpdateEmail -> {
                _registerState.value = _registerState.value.copy(email = loginScreenEvents.email)
            }

            is RegisterScreenEvents.UpdatePassword -> {
                _registerState.value =
                    _registerState.value.copy(password = loginScreenEvents.password)
            }
        }
    }
}
