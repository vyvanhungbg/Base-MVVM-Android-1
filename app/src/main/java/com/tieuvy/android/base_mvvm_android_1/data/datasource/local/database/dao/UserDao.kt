package com.tieuvy.android.base_mvvm_android_1.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.tieuvy.android.base_mvvm_android_1.data.model.User
import com.tieuvy.android.base_mvvm_android_1.utils.constant.Constant

@Dao
interface UserDao {

    @Query("SELECT * FROM ${Constant.DB.TABLES.USER} WHERE id =:id")
    suspend fun getUserById(id: Long): User?
}