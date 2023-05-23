package com.tieuvy.android.base_mvvm_android_1.di

import com.tieuvy.android.base_mvvm_android_1.data.repository.user.IUserRepository
import com.tieuvy.android.base_mvvm_android_1.data.repository.user.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IUserRepository> { UserRepository(get()) }
}