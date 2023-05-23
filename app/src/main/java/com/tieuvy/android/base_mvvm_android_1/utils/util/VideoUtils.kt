package com.tieuvy.android.base_mvvm_android_1.utils.util

import com.tieuvy.android.base_mvvm_android_1.utils.util.CryptoUtils.decrypt
import com.tieuvy.android.base_mvvm_android_1.utils.util.CryptoUtils.encrypt
import java.io.InputStream
import java.nio.charset.StandardCharsets


object VideoUtils {
    private const val KEY = "01234567890123456789012345678901"
    private val IV = "0123456789012345".toByteArray(StandardCharsets.UTF_8)

    fun encryptVideo(inputStream: InputStream): String {
        val data = ByteArray(inputStream.available())
        inputStream.read(data)
        return encrypt(KEY, IV, data)
    }


    fun decryptVideo(encryptedData: String?): ByteArray {
        return decrypt(KEY, IV, encryptedData)
    }
}
