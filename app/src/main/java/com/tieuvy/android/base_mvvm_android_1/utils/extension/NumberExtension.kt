package com.tieuvy.android.base_mvvm_android_1.utils.extension

fun Long.toMinutesSecond(): String {
    return String.format("%02d:%02d", this / 60, this % 60)
}

fun Long.toMinutesSecondExpand(): String {
    return String.format("%02dp:%02ds", this / 60, this % 60)
}


fun Int.convertToSecond(): Long {
    return this * 60L;
}

fun Float.toPercent(): String {
    return String.format("%.2f%%", this)
}

fun Int.toPercent(): String {
    return String.format("%d%%", this)
}