package com.clyo.core.android

import android.view.ViewGroup
import com.eliascoelho911.clyo.ScreenData
import com.eliascoelho911.clyo.ScreenRenderer

class AndroidScreenRenderer(
    private val rootView: ViewGroup,
    private val viewProvider: ViewProvider
) : ScreenRenderer {
    override fun render(data: ScreenData) {
        val view = viewProvider.provide(
            context = rootView.context,
            data = data.content
        )
        rootView.addView(view)
    }
}