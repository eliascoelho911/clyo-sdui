package com.clyo.android.ui

import android.content.Context
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.container.ContainerProvider
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

// Todo: Essa classe não deveria conhecer o Json
class ClyoScreen internal constructor(
    private val json: Json,
    private val widgetProvider: WidgetProvider,
    private val containerProvider: ContainerProvider
) {

    fun create(context: Context, json: ContainerJson): Container<*> {
        val container = containerProvider.provideInstanceByType(context, json.type)

        json.content.forEach { widgetJson ->
            container.add(widgetProvider.provideInstanceByType(context, widgetJson.type))
        }

        return container
    }

    fun render(container: Container<*>, propertiesJson: PropertiesJson) {
        container.children.forEach { widget ->
            val properties = propertiesJson.decodeProperties(json, widget.id)
            widget.render(properties)
        }
    }
}