package com.tieuvy.android.base_mvvm_android_1.di

import com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.AppClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single { provideClient() }
}

fun provideClient(): HttpClient {
    return AppClient.getInstance()
}