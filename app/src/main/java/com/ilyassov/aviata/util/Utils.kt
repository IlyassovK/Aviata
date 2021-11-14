package com.ilyassov.aviata.util

import java.text.DateFormat
import java.text.SimpleDateFormat

object Utils {
    const val API_KEY = "e65ee0938a2a43ebb15923b48faed18d"

    val serverDateFormat= SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val dateFormat = SimpleDateFormat("dd.MM.yyyy, HH:mm")
    var change: Boolean = true
}