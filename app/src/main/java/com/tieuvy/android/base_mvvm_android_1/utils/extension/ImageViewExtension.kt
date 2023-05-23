package com.tieuvy.android.base_mvvm_android_1.utils.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import de.hdodenhof.circleimageview.CircleImageView

fun ImageView.loadImage(path: String?) {
    Glide.with(this)
        .load(path?.toUri())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadImageNoCache(path: String?) {
    Glide.with(this)
        .load(path?.toUri())
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}



fun ImageView.loadImage(@DrawableRes drawable: Int) {
    Glide.with(this)
        .load(drawable)
        .transition(DrawableTransitionOptions.withCrossFade())
        .dontAnimate()
        .into(this)
}

fun ImageView.loadGif(@DrawableRes drawable: Int) {
    Glide.with(this)
        .asGif()
        .load(drawable)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}


fun CircleImageView.loadImage(@DrawableRes drawable: Int) {
    Glide.with(this)
        .load(drawable)
        .transition(DrawableTransitionOptions.withCrossFade())
        .dontAnimate()
        .into(this)
}


