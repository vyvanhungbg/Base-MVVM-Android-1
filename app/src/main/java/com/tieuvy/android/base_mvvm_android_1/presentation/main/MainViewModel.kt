package com.tieuvy.android.base_mvvm_android_1.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tieuvy.android.base_mvvm_android_1.base.BaseViewModel
import com.tieuvy.android.base_mvvm_android_1.data.model.User
import com.tieuvy.android.base_mvvm_android_1.domain.SearchUserByNameUserCase

private const val TAG = "MainViewModel"
class MainViewModel(
    private val searchUserByNameUserCase: SearchUserByNameUserCase
) : BaseViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users


    fun searchUsersByName(name: String) {
        executeTask(
            request = { searchUserByNameUserCase.searchUsersByName(name) },
            onSuccess = {
                        _users.value = it.items
            },
            onError = {
                it.printStackTrace()
                Log.e(TAG, "searchUsersByName: ${it.message}", )

            }
        )
    }
}