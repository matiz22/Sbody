package pl.sbody.app

import android.app.Application
import pl.sbody.app.di.KoinInitializer

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}
