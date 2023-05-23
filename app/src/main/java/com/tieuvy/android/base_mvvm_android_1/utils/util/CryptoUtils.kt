package com.tieuvy.android.base_mvvm_android_1.utils.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object CryptoUtils {


    fun encrypt(key: String, iv: ByteArray?, data: ByteArray?): String {
        val keySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, IvParameterSpec(iv))
        val encryptedData = cipher.doFinal(data)
        return Base64.encodeToString(encryptedData, Base64.DEFAULT)
    }


    fun decrypt(key: String, iv: ByteArray?, encodedData: String?): ByteArray {
        val keySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, keySpec, IvParameterSpec(iv))
        val decodedData = Base64.decode(encodedData, Base64.DEFAULT)
        return cipher.doFinal(decodedData)
    }
}