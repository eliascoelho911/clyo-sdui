package com.clyo.android.tools

import com.clyo.android.ui.Container
import com.clyo.data.container.ContainerJson
import com.clyo.data.widget.WidgetJson

abstract class ContainerFactory(
    private val widgetProvider: WidgetProvider
) {
    abstract fun provide(type: String): Container<*>

    fun create(json: ContainerJson): Container<*> {
        return provide(json.type).addAllWidgets(widgetProvider, json.content)
    }
}

internal fun containerFactory() = tools().containerFactory

private fun Container<*>.addAllWidgets(
    widgetProvider: WidgetProvider,
    json: List<WidgetJson>
): Container<*> {
    json.forEach(widgetProvider::provide)

    return this
}