package com.eliascoelho911.clyo.android

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.clyo.core.android.AndroidScreenRenderer
import com.clyo.core.android.ViewProvider
import com.eliascoelho911.clyo.android.components.ButtonComponentViewFactory
import com.eliascoelho911.clyo.startClyo

fun AppCompatActivity.startAndroidClyo(@IdRes rootId: Int) {
    startClyo(
        screenRenderer = AndroidScreenRenderer(
            rootView = findViewById(rootId),
            viewProvider = findViewProvider()
        )
    )
}

private fun findViewProvider(): ViewProvider {
    return ViewProvider(
        viewFactoryClasses = setOf(ButtonComponentViewFactory::class)
    )
}
