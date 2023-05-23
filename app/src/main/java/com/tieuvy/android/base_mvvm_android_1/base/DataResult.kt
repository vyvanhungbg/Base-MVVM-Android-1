package com.tieuvy.android.base_mvvm_android_1.base

sealed class DataResult<out T> {

    data class Success<T>(val data: T) : DataResult<T>()
    data class Error(val exception: Exception) : DataResult<Nothing>()
}
