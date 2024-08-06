package pl.sbody.auth.presentation.states

data class RegisterScreenState(
    val email: String = "",
    val emailError: String? = null,
    val emailEnabled: Boolean = true,
    val password: String = "",
    val passwordError: String? = null,
    val buttonEnabled: Boolean = true,
)
