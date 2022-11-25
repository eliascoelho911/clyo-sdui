package com.clyo.core

import android.view.ViewGroup
import com.clyo.core.component.renderer.ComponentRendererProvider
import com.clyo.core.data.ScreenData
import java.io.Closeable

class ScreenRenderer(
    val componentRendererProvider: ComponentRendererProvider
): Closeable {
    fun render(data: ScreenData, parent: ViewGroup) {
        val contentData = data.content
        parent.addView(
            componentRendererProvider.provideContainerRenderer(contentData.name).render(
                context = parent.context,
                data = contentData
            )
        )
    }

    override fun close() {
        componentRendererProvider.close()
    }
}

fun getScreenRenderer(): ScreenRenderer = Clyo.engine.screenRenderer