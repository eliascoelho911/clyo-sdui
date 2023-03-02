package com.clyo.android

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.koin.ClyoKoinContext

class ClyoEngine internal constructor(
    private val clyoComponents: ClyoComponents,
    private val clyoRenderer: ClyoRenderer
) {
    fun init(context: Context) {
        ClyoKoinContext.initKoin(context)
    }

    fun render(data: ClyoData, container: ViewGroup) {
        clyoRenderer.render(data, container)
    }
}