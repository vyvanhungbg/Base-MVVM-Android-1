package com.tieuvy.android.base_mvvm_android_1.domain

import com.tieuvy.android.base_mvvm_android_1.base.DataResult
import com.tieuvy.android.base_mvvm_android_1.data.model.BaseResponseGitHub
import com.tieuvy.android.base_mvvm_android_1.data.model.User
import com.tieuvy.android.base_mvvm_android_1.data.repository.user.IUserRepository

class SearchUserByNameUserCase(private val repo: IUserRepository) {

    suspend fun searchUsersByName(name: String): DataResult<BaseResponseGitHub<User>>{
        return repo.searchUserByName(name)
    }
}