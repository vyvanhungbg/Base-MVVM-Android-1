package com.tieuvy.android.base_mvvm_android_1.presentation.main

import android.util.Log
import com.tieuvy.android.base_mvvm_android_1.base.BaseActivity
import com.tieuvy.android.base_mvvm_android_1.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel by viewModel<MainViewModel>()

    override fun initData() {
        viewModel.searchUsersByName("vyvanhung")
    }

    override fun handleEvent() {
        binding.btn.setOnClickListener {
            viewModel.searchUsersByName(binding.editText.text.toString())
        }
    }

    override fun bindData() {
        viewModel.users.observe(this){
            binding.textView.text = it.toString()
            Log.e(TAG, "bindData: ${it.toString()}", )
        }
    }


}