package pl.sbody.core.presentation.di.util

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.currentKoinScope

@Composable
inline fun <reified T : ViewModel> koinViewModel(
    viewModelStoreOwner: ViewModelStoreOwner =
        checkNotNull(LocalViewModelStoreOwner.current) {
            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
        },
): T {
    val scope = currentKoinScope()
    return viewModel(viewModelStoreOwner = viewModelStoreOwner) { scope.get<T>() }
}
