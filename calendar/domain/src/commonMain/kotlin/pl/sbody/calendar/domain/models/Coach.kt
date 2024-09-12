package pl.sbody.calendar.domain.models

/**
 * Represents a coach with an ID, name, and surname.
 *
 * @property id The unique identifier for the coach.
 * @property name The coach's first name.
 * @property surname The coach's last name.
 */
data class Coach(
    val id: Int,
    val name: String,
    val surname: String,
)
