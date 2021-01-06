package com.saregama.mvvmmusicapp.util

import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import com.saregama.mvvmmusicapp.di.Qualifiers.charset

object Utils{

    fun encode(value: String): String {
        try {
            return URLEncoder.encode(value, charset)
        } catch (e: UnsupportedEncodingException) {
            return value
        }
    }
}