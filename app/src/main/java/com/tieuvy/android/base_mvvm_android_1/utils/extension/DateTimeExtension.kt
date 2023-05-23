package com.tieuvy.android.base_mvvm_android_1.utils.extension


import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun Date.toDateTimeForHuman(
    pattern: String = "EEE dd-MM-yyyy 'lúc' HH:mm",
    locale: Locale = Locale("vi", "VN")
): String {
     try {
         val patternNotDayOfWeek = " dd-MM-yyyy 'lúc' HH:mm"
         val timeFormatter = SimpleDateFormat(patternNotDayOfWeek, locale)
        val today = Date()
        val yesterday = getYesterday()

        return if (this.isThisDay(today)) {
            "Hôm nay " + timeFormatter.format(this)
        } else if (this.isThisDay(yesterday)) {
            "Hôm qua " + timeFormatter.format(this)
        } else {
            val dateFormat = SimpleDateFormat(pattern, locale)
            dateFormat.format(this).toString()
        }
    } catch (e: Exception) {
        return ""
    }
}

fun Date.toDateTimeFilePDF(
    locale: Locale = Locale("vi", "VN")
): String {
    return try {
        val patternNotDayOfWeek = " dd-MM-yyyy-HH:mm"

        val dateFormat = SimpleDateFormat(patternNotDayOfWeek, locale)
        dateFormat.format(this).toString()
    } catch (e: Exception) {
        ""
    }
}

private fun getYesterday(): Date {
    return Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)
}

private fun Date.isThisDay(
    date: Date?,
    patternCompare: String = "yyyy-MM-dd",
    locale: Locale = Locale("vi", "VN")
): Boolean {
    if(date == null )
        return false
    val timeCompare = SimpleDateFormat(patternCompare, locale)
    return timeCompare.format(date).equals(timeCompare.format(this))
}