package com.tieuvy.android.base_mvvm_android_1.di

import com.tieuvy.android.base_mvvm_android_1.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}