package pl.sbody.core.presentation.models

data class UserSummary(
    val id: Int,
    val name: String,
    val surname: String,
    val balance: Float,
    val photoUrl: String,
)
