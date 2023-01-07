package com.clyo.android.util

import com.clyo.android.ClyoView
import com.clyo.android.component.ComponentFactory
import com.clyo.data.ClyoData

internal class ClyoRenderer(
    private val componentFactory: ComponentFactory
) {
    fun render(data: ClyoData, container: ClyoView) {
        val containerData = data.container

        return componentFactory.create(containerData.name).also {
            it.bind(containerData.properties)
        }.let { container.addComponent(it) }
    }
}