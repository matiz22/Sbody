package pl.sbody.app.di.modules

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import pl.sbody.auth.presentation.viewmodels.LoginViewModel
import pl.sbody.auth.presentation.viewmodels.RegisterViewModel

actual fun authViewModelsModule() = module {
    singleOf(::LoginViewModel)
    singleOf(::RegisterViewModel)
}
