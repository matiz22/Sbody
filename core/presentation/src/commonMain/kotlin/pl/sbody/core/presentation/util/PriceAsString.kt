package pl.sbody.core.presentation.util

fun Float.priceAsString(): String {
    val roundedPrice = (this * 100).toLong() / 100.0
    val priceString = roundedPrice.toString()

    return if ("." in priceString) {
        val (whole, fraction) = priceString.split(".")
        "$whole.${fraction.padEnd(2, '0')}"
    } else {
        "$priceString.00"
    }
}
