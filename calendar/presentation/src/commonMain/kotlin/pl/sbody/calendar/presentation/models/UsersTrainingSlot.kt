@file:Suppress("ktlint:standard:filename")

package pl.sbody.calendar.presentation.models

import kotlinx.datetime.LocalDateTime
import pl.sbody.calendar.domain.models.Coach
import pl.sbody.calendar.domain.models.SlotType
import pl.sbody.calendar.domain.models.TrainingSlot

data class UsersTrainingSlot(
    val id: Int,
    val coach: Coach,
    val startDateTime: LocalDateTime,
    val length: Int,
    val note: String,
    val status: Int,
    val price: Boolean,
    val paid: Int,
    val type: SlotType,
    val occurred: Boolean,
) {
    companion object {
        fun fromTrainingSlots(trainingSlot: TrainingSlot): UsersTrainingSlot =
            UsersTrainingSlot(
                id = trainingSlot.id,
                coach = trainingSlot.coach,
                startDateTime = LocalDateTime.parse(trainingSlot.startDateTime),
                length = trainingSlot.length,
                note = trainingSlot.note,
                status = trainingSlot.status,
                price = trainingSlot.price,
                paid = trainingSlot.paid,
                type = trainingSlot.type,
                occurred = trainingSlot.occurred,
            )
    }
}
