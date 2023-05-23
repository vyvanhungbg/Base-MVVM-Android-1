package com.tieuvy.android.base_mvvm_android_1.utils.extension

import android.media.AudioAttributes
import android.media.MediaPlayer

class MediaPlayerExtension {
    companion object {
        private var instance: MediaPlayer? = null
        fun getInstance(): MediaPlayer = synchronized(this) {
            instance ?: MediaPlayer().also {
                it.setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                instance = it
            }
        }
    }
}

fun MediaPlayer.play(path : String){
    this.reset()
    this.setDataSource(path)
    prepare()
    start()
}



