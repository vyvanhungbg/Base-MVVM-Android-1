package com.tieuvy.android.base_mvvm_android_1.data.datasource.local.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tieuvy.android.base_mvvm_android_1.BuildConfig
import com.tieuvy.android.base_mvvm_android_1.data.datasource.local.database.dao.UserDao
import com.tieuvy.android.base_mvvm_android_1.data.model.User
import com.tieuvy.android.base_mvvm_android_1.utils.constant.Constant
import java.util.concurrent.Executors

private const val TAG = "AppDatabase"

@Database(entities = [User::class], version = Constant.DB.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, Constant.DB.NAME)
                .setQueryCallback(
                    { a, b ->
                        if (BuildConfig.DEBUG) {
                            Log.e(TAG, "QUERY [$a , ${b.toString()}] ")
                        }
                    },
                    Executors.newSingleThreadExecutor()
                ).build()
    }
}