package com.tieuvy.android.base_mvvm_android_1.utils.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter


import java.util.Date

@ProvidedTypeConverter
class ObjectTypeConverters {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

}