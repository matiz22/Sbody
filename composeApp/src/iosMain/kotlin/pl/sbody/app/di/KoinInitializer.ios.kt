package pl.sbody.app.di

import org.koin.core.context.startKoin
import pl.sbody.app.di.modules.authViewModelsModule

actual class KoinInitializer {
    actual fun init() {
        startKoin { modules(authViewModelsModule()) }
    }
}
