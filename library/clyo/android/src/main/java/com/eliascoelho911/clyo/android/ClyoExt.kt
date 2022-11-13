package com.eliascoelho911.clyo.android

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.clyo.core.android.AndroidScreenRenderer
import com.clyo.core.android.ViewProvider

fun AppCompatActivity.startAndroidClyo(@IdRes rootId: Int) {
    com.eliascoelho911.clyo.startClyo(
        screenRenderer = AndroidScreenRenderer(
            rootView = findViewById(rootId),
            viewProvider = ViewProvider(
                componentViewCreators = setOf()
            )
        )
    )
}