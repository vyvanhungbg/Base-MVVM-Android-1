package com.tieuvy.android.base_mvvm_android_1.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseGitHub<T>(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("incomplete_results")
    val inCompleteResults: Boolean,
    val items: List<T>
)