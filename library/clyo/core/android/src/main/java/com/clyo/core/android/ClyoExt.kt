package com.clyo.core.android

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.eliascoelho911.clyo.startClyo

fun AppCompatActivity.startAndroidClyo(@IdRes rootId: Int) {
    startClyo(
        screenRenderer = AndroidScreenRenderer(
            rootView = findViewById(rootId),
            viewProvider = ViewProvider()
        )
    )
}