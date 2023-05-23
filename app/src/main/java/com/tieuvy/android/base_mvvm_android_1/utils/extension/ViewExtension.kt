package com.tieuvy.android.base_mvvm_android_1.utils.extension

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar



fun View.hide() {
    this.isVisible = false
}

fun View.show() {
    this.isVisible = true
}

fun View.showSnackBar(message: String?, buttonText: String? = null, onClick: () -> Unit = {}) {
    val snackBar = Snackbar.make(this, message.toString(), Snackbar.LENGTH_LONG).apply {
        setAction(buttonText) {
            onClick()
            this.dismiss()
        }
        /*setTextColor(ContextCompat.getColor(this.context, R.color.color_main_900))
        setActionTextColor(ContextCompat.getColor(this.context, R.color.color_main_900))
        view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white))*/
    }
    snackBar.show()
}
