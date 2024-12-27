@file:Suppress("ktlint:standard:filename")

package pl.sbody

import App
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import pl.sbody.app.di.KoinInitializer

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    KoinInitializer().init()
    ComposeViewport(document.body!!) {
        App()
    }
}
