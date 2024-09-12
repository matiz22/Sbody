package pl.sbody.calendar.domain.models

/**
 * Represents a training slot with details about the coach, timing, and other relevant information.
 *
 * @property id The uniqueidentifier for the training slot.
 * @property coach The coach assigned to this training slot.
 * @property startDateTime The starting date and time of the training slot example: 2010-06-01T22:19:44.
 * @property length The duration of the training slot in minutes.
 * @property note Any additional notes or informationabout the training slot.
 * @property status The status of the training slot (e.g., booked, available, canceled). Further clarification on status codes is needed.
 * @property price Indicates whether the training slot has a price associated with it.
 * @property paid  The payment status of the training slot (requires further clarification on possible values and their meaning).
 * @property type The type of slot (zdrowie).
 * @property occurred Indicates whether the training slot has already occurred.
 */
data class TrainingSlot(
    val id: Int,
    val coach: Coach,
    val startDateTime: String,
    val length: Int,
    val note: String,
    val status: Int,
    val price: Float,
    val paid: Int,
    val type: SlotType,
    val occurred: Boolean,
)
