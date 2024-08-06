import androidx.compose.ui.window.ComposeUIViewController
import pl.sbody.app.di.KoinInitializer

@Suppress("ktlint:standard:function-naming")
fun MainViewController() =
    ComposeUIViewController(configure = { KoinInitializer().init() }) { App() }
