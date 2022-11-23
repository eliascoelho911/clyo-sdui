package com.clyo.core

import android.view.ViewGroup
import com.clyo.core.component.instantiateView
import com.clyo.core.data.ScreenData

class AndroidScreenRenderer(private val rootView: ViewGroup) {
    fun render(data: ScreenData) {
        rootView.addView(instantiateView(rootView.context, data.content))
    }
}