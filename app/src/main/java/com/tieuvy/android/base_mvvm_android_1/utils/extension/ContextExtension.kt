package com.tieuvy.android.base_mvvm_android_1.utils.extension

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import java.util.Calendar
import java.util.Locale

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(resource: Int) {
    Toast.makeText(this, resource, Toast.LENGTH_SHORT).show()
}

fun Context.color(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun Context.drawable(@DrawableRes drawable: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawable)
}

fun Context.pickDateTime(action: (hour: Int, minute: Int) -> Unit) {
    Locale.setDefault(Locale("vi"))
    val currentDateTime = Calendar.getInstance()
    val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
    val startMinute = currentDateTime.get(Calendar.MINUTE)
    TimePickerDialog(
        this,
        AlertDialog.THEME_HOLO_LIGHT,
        TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            action(
                hour,
                minute
            )
        },
        startHour,
        startMinute,
        true
    ).apply {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        show()
    }
}
