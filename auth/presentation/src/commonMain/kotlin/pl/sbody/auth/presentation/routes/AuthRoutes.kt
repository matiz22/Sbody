package pl.sbody.auth.presentation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class AuthRoutes {
    @Serializable
    data object AuthScreens : AuthRoutes() {
        @Serializable data object WelcomeScreen : AuthRoutes()

        @Serializable data object LoginScreen : AuthRoutes()

        @Serializable data object RegisterScreen : AuthRoutes()
    }
}
