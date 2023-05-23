package com.tieuvy.android.base_mvvm_android_1

import android.app.Application
import com.tieuvy.android.base_mvvm_android_1.di.dataSourceModule
import com.tieuvy.android.base_mvvm_android_1.di.databaseModule
import com.tieuvy.android.base_mvvm_android_1.di.networkModule
import com.tieuvy.android.base_mvvm_android_1.di.repositoryModule
import com.tieuvy.android.base_mvvm_android_1.di.useCaseModule
import com.tieuvy.android.base_mvvm_android_1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                databaseModule,
                networkModule
            )
        }
    }
}