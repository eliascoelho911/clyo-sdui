package com.eliascoelho911.clyo.android

import android.view.ViewGroup
import com.clyo.core.android.ViewProvider
import com.eliascoelho911.clyo.ScreenData
import com.eliascoelho911.clyo.ScreenRenderer

class AndroidScreenRenderer(
    private val rootView: ViewGroup,
    private val viewProvider: ViewProvider
) : ScreenRenderer {
    override fun render(data: ScreenData) {
        val view = viewProvider.provide(
            context = rootView.context,
            componentData = data.content
        )
        rootView.addView(view)
    }
}