package com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.user

import com.tieuvy.android.base_mvvm_android_1.data.model.BaseResponseGitHub
import com.tieuvy.android.base_mvvm_android_1.data.model.User

interface IUserDataSource {

    interface Remote {
        suspend fun searchUserByName(name: String): BaseResponseGitHub<User>
    }
}