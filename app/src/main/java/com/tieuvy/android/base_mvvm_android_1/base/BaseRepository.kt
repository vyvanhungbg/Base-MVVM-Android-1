package com.tieuvy.android.base_mvvm_android_1.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

open class BaseRepository {

    suspend fun <T> getResult(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        request: suspend CoroutineScope.() -> T
    ): DataResult<T> {
        return withContext(dispatcher) {
            try {
                DataResult.Success(request())
            } catch (e: IOException) {
                DataResult.Error(e)
            }
        }
    }
}