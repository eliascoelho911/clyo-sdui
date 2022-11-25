package com.clyo.core

import android.view.ViewGroup
import com.clyo.core.data.ScreenData
import java.io.Closeable

class ClyoEngine(val screenRenderer: ScreenRenderer): Closeable {
    fun showScreen(data: ScreenData, parent: ViewGroup) {
        screenRenderer.render(data, parent)
    }

    override fun close() {
        screenRenderer.close()
    }
}