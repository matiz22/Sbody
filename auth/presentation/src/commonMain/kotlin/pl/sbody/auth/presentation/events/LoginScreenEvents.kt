package pl.sbody.auth.presentation.events

sealed class LoginScreenEvents {
    data class UpdateEmail(val email: String) : LoginScreenEvents()

    data class UpdatePassword(val password: String) : LoginScreenEvents()

    data object Submit : LoginScreenEvents()
}
