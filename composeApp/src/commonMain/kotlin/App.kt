import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import pl.sbody.auth.presentation.graphs.authGraph
import pl.sbody.auth.presentation.routes.AuthRoutes
import pl.sbody.core.presentation.theme.AppTheme

@Composable
fun App() {
    KoinContext {
        AppTheme(darkTheme = isSystemInDarkTheme()) {
            val navController = rememberNavController()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing),
                    color = Color.Transparent,
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AuthRoutes.AuthScreens,
                    ) {
                        authGraph(navController)
                    }
                }
            }
        }
    }
}
