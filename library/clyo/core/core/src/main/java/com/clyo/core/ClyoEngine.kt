package com.clyo.core

import com.clyo.core.data.ScreenData

class ClyoEngine(private val screenRenderer: AndroidScreenRenderer) {
    fun submitScreen(screenData: ScreenData) {
        screenRenderer.render(screenData)
    }
}