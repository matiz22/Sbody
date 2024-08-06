package pl.sbody.app.di.modules

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import pl.sbody.auth.presentation.viewmodels.LoginViewModel

actual fun authViewModelsModule() = module { viewModel { LoginViewModel() } }
