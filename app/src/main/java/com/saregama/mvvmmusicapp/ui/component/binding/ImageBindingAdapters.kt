package com.saregama.mvvmmusicapp.ui.component.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter


object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, imagePath: String) {
//        GlideApp.with(view.context)
//                .load(imagePath)
//                .into(view)
    }

    @JvmStatic
    @BindingAdapter("circle_image")
    fun loadCircleImage(view: ImageView, imagePath: String) {
//        GlideApp.with(view.context)
//                .load(imagePath)
//                .apply(RequestOptions.circleCropTransform())
//                .into(view)
    }
}