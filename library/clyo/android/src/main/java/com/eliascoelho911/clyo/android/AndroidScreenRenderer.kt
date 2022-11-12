package com.eliascoelho911.clyo.android

import android.view.ViewGroup
import com.clyo.core.android.ViewProvider
import com.eliascoelho911.clyo.ScreenRenderer
import com.eliascoelho911.clyo.android.components.ButtonData
import com.eliascoelho911.clyo.data.ScreenData

class AndroidScreenRenderer(
    private val rootView: ViewGroup,
    private val viewProvider: ViewProvider
) : ScreenRenderer {
    override fun render(data: ScreenData) {
        val view = viewProvider.provide(context = rootView.context, componentData = data.content as ButtonData)
        rootView.addView(view)
    }
}