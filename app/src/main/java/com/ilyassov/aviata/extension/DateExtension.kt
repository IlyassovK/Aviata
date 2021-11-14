package com.ilyassov.aviata.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDateTime(
    inputDateFormat: SimpleDateFormat,
    outputDateFormat: SimpleDateFormat
): String {
    val dateTime: Date = inputDateFormat.parse(this)
    return outputDateFormat.format(dateTime)
}