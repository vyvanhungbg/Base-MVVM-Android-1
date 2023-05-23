package com.tieuvy.android.base_mvvm_android_1.di

import com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.user.IUserDataSource
import com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.user.UserRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<IUserDataSource.Remote> { UserRemoteDataSource(get()) }
}