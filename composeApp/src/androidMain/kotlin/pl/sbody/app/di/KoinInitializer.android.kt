package pl.sbody.app.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import pl.sbody.app.di.modules.authViewModelsModule

actual class KoinInitializer(
    private val context: Context,
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(authViewModelsModule())
        }
    }
}
