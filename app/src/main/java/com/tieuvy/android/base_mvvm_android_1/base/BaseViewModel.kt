package com.tieuvy.android.base_mvvm_android_1.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tieuvy.android.base_mvvm_android_1.utils.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val loading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = loading

    protected val error = SingleLiveEvent<String>()
    val hasError: LiveData<String>
        get() = error


    protected fun <T> executeTask(
        request: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit = {},
        showLoading: Boolean = true
    ) {
        if (showLoading) showLoading()
        viewModelScope.launch {
            when (val response = request(this)) {
                is DataResult.Success -> {
                    onSuccess(response.data)
                    hideLoading()
                }
                is DataResult.Error -> {
                    onError(response.exception)
                    hideLoading()
                }
            }
        }
    }

    private fun showLoading() {
        loading.value = true
    }

    fun hideLoading() {
        loading.value = false
    }


}
