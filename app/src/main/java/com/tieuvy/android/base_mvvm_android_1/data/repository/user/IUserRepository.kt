package com.tieuvy.android.base_mvvm_android_1.data.repository.user

import com.tieuvy.android.base_mvvm_android_1.base.DataResult
import com.tieuvy.android.base_mvvm_android_1.data.model.BaseResponseGitHub
import com.tieuvy.android.base_mvvm_android_1.data.model.User

interface IUserRepository {

    suspend fun searchUserByName(name: String): DataResult<BaseResponseGitHub<User>>
}