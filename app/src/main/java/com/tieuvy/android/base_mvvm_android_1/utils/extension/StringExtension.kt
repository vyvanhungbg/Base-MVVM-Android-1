package com.tieuvy.android.base_mvvm_android_1.utils.extension

import java.text.Normalizer
import java.util.regex.Pattern


fun String?.normalizeVietnamese(): String {
    try {
        val nfdNormalizedString: String = Normalizer.normalize(this, Normalizer.Form.NFD)
        val pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        return pattern.matcher(nfdNormalizedString).replaceAll("")
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return ""
}