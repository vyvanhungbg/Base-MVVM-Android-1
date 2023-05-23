package com.tieuvy.android.base_mvvm_android_1.di

import com.tieuvy.android.base_mvvm_android_1.domain.SearchUserByNameUserCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single { SearchUserByNameUserCase(get()) }
}