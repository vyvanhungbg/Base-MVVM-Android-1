package com.tieuvy.android.base_mvvm_android_1.data.repository.user

import com.tieuvy.android.base_mvvm_android_1.base.BaseRepository
import com.tieuvy.android.base_mvvm_android_1.base.DataResult
import com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.user.IUserDataSource
import com.tieuvy.android.base_mvvm_android_1.data.model.BaseResponseGitHub
import com.tieuvy.android.base_mvvm_android_1.data.model.User

class UserRepository(private val remote: IUserDataSource.Remote) : BaseRepository(),
    IUserRepository {
    override suspend fun searchUserByName(name: String): DataResult<BaseResponseGitHub<User>> {
        return getResult { remote.searchUserByName(name) }
    }
}