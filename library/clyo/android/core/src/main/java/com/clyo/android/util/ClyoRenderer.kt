package com.clyo.android.util

import com.clyo.android.ClyoData
import com.clyo.android.ClyoView
import com.clyo.android.component.ComponentFactory

internal class ClyoRenderer(
    private val componentFactory: ComponentFactory
) {
    fun render(data: ClyoData, container: ClyoView) {
        val containerData = data.root

        return componentFactory.create(containerData.name).also {
            it.bind(containerData.properties)
        }.let { container.show(it) }
    }
}