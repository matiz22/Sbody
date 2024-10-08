package pl.sbody.auth.presentation.graphs

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.sbody.auth.presentation.routes.AuthRoutes
import pl.sbody.auth.presentation.screens.LoginScreen
import pl.sbody.auth.presentation.screens.RegisterScreen
import pl.sbody.auth.presentation.screens.WelcomeScreen
import pl.sbody.auth.presentation.viewmodels.LoginViewModel
import pl.sbody.auth.presentation.viewmodels.RegisterViewModel
import pl.sbody.core.presentation.di.util.koinViewModel

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation<AuthRoutes.AuthScreens>(startDestination = AuthRoutes.AuthScreens.WelcomeScreen) {
        composable<AuthRoutes.AuthScreens.WelcomeScreen> {
            WelcomeScreen(
                onRegisterClick = { navController.navigate(AuthRoutes.AuthScreens.RegisterScreen) },
                onLoginClick = { navController.navigate(AuthRoutes.AuthScreens.LoginScreen) },
            )
        }
        composable<AuthRoutes.AuthScreens.LoginScreen> { navBackStackEntry ->
            val loginViewModel =
                koinViewModel<LoginViewModel>(viewModelStoreOwner = navBackStackEntry)
            val loginScreenState by
                loginViewModel.loginState.collectAsStateWithLifecycle(navBackStackEntry)
            LoginScreen(loginScreenState = loginScreenState, onEvent = loginViewModel::onEvent)
        }
        composable<AuthRoutes.AuthScreens.RegisterScreen> { navBackStackEntry ->
            val registerViewModel =
                koinViewModel<RegisterViewModel>(viewModelStoreOwner = navBackStackEntry)
            val registerScreenState by
                registerViewModel.registerState.collectAsStateWithLifecycle(navBackStackEntry)
            RegisterScreen(
                loginScreenState = registerScreenState,
                onEvent = registerViewModel::onEvent,
            )
        }
    }
}
