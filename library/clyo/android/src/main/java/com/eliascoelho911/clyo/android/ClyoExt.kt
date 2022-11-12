package com.eliascoelho911.clyo.android

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.clyo.core.android.ViewProvider
import com.eliascoelho911.clyo.android.components.ButtonData
import com.eliascoelho911.clyo.android.components.ButtonViewCreator

fun AppCompatActivity.startAndroidClyo(@IdRes rootId: Int) {
    com.eliascoelho911.clyo.startClyo(
        screenRenderer = AndroidScreenRenderer(
            rootView = findViewById(rootId),
            viewProvider = ViewProvider(
                componentViewCreators = mapOf(ButtonData::class to ButtonViewCreator)
            )
        )
    )
}