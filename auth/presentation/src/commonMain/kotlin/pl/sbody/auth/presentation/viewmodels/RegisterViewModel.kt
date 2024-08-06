package pl.sbody.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pl.sbody.auth.presentation.events.RegisterScreenEvents
import pl.sbody.auth.presentation.states.RegisterScreenState

class RegisterViewModel : ViewModel() {

    private val _registerState = MutableStateFlow<RegisterScreenState>(RegisterScreenState())
    val registerState = _registerState.asStateFlow()

    fun onEvent(loginScreenEvents: RegisterScreenEvents) {
        when (loginScreenEvents) {
            RegisterScreenEvents.Submit -> TODO("Implement register functionality")
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
