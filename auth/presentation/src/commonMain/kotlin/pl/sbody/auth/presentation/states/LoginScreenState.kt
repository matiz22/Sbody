package pl.sbody.auth.presentation.states

data class LoginScreenState(
    val email: String = "",
    val emailError: String? = null,
    val emailEnabled: Boolean = true,
    val password: String = "",
    val passwordError: String? = null,
    val passwordEnabled: Boolean = true,
    val submitButtonEnabled: Boolean = true,
)
