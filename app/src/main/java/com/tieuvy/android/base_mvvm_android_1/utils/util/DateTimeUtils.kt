package com.tieuvy.android.base_mvvm_android_1.utils.util

object DateTimeUtils {

    fun formatTime(hour: Int, minute: Int): String {
        return "%02d:%02d".format(hour, minute)
    }
}