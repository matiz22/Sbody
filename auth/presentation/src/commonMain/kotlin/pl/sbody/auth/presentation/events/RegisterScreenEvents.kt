package pl.sbody.auth.presentation.events

sealed class RegisterScreenEvents {
    data class UpdateEmail(val email: String) : RegisterScreenEvents()

    data class UpdatePassword(val password: String) : RegisterScreenEvents()

    data object Submit : RegisterScreenEvents()
}
