package com.clyo.core

import android.view.ViewGroup
import com.clyo.core.data.ScreenData

class ScreenRenderer {
    fun render(data: ScreenData, parent: ViewGroup) {
        val container = buildComponent(
            context = parent.context,
            data = data.content
        )
        parent.apply {
            removeAllViews()
            addView(container)
        }
    }
}