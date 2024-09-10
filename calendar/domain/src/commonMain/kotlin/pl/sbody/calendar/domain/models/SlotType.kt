package pl.sbody.calendar.domain.models

/**
 * Represents a type of training slot with an ID, name, and description.
 *
 * @property id The unique identifier for the slot type.
 * @property name The name of the slot type.
 * @property description A detailed description of the slot type.
 */
data class SlotType(
    val id: Int,
    val name: String,
    val description: String,
)
