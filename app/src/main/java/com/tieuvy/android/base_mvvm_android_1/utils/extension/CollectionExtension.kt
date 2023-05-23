package com.tieuvy.android.base_mvvm_android_1.utils.extension


fun <T> MutableList<T>.addNewList(newList: List<T>) {
    this.clear()
    this.addAll(newList)
}