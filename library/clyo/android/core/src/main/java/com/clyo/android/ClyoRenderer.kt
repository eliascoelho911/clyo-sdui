package com.clyo.android

import com.clyo.android.component.widget.WidgetFactory

internal class ClyoRenderer(
    private val widgetFactory: WidgetFactory
) {
    fun render(data: ClyoData, parent: ClyoView) {
        val containerData = data.root

        return widgetFactory.create(parent.context, containerData.name).also {
            it.bind(containerData.properties)
        }.let { parent.show(it) }
    }
}