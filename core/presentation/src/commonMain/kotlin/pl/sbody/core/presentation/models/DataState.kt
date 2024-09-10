package pl.matiz22.cocktailapp.android.core.states

sealed class DataState<out T> {
    data object Loading : DataState<Nothing>()

    data class Success<out T>(
        val data: T,
    ) : DataState<T>()

    data class Error(
        val message: String,
    ) : DataState<Nothing>()
}
