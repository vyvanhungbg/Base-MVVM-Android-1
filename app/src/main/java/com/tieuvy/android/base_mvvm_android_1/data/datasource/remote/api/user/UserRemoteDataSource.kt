package com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.user

import com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.url.ApiSearch
import com.tieuvy.android.base_mvvm_android_1.data.model.BaseResponseGitHub
import com.tieuvy.android.base_mvvm_android_1.data.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get

class UserRemoteDataSource(private val client: HttpClient) : IUserDataSource.Remote {
    override suspend fun searchUserByName(name: String): BaseResponseGitHub<User> {
        //return client.get("https://api.github.com/search/users?q=${name}").body() as BaseResponseGitHub<User>
        return client.get(ApiSearch.User(name)).body() as BaseResponseGitHub<User>
    }


}