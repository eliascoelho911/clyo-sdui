package com.eliascoelho911.clyo

class ClyoEngine(private val screenRenderer: ScreenRenderer) {
    fun close() {}

    fun submitScreen(screenData: ScreenData) {
        screenRenderer.render(screenData)
    }
}