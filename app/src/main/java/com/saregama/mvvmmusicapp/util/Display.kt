package com.saregama.mvvmmusicapp.util

import android.view.View
import android.view.Window


class Display {
    companion object {
        fun showSystemUi(window: Window) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }
}