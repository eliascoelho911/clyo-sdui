package com.clyo.android

import android.view.ViewGroup

class ClyoEngine internal constructor(
    private val clyoRenderer: ClyoRenderer
) {
    fun render(data: ClyoData, container: ViewGroup) {
        clyoRenderer.render(data, container)
    }
}