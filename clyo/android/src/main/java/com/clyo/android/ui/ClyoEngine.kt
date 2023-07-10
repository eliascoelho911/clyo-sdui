package com.clyo.android.ui

import android.content.Context
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.component.ComponentFactory
import com.clyo.android.ui.component.ContainerFactory
import com.clyo.android.ui.component.WidgetFactory
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

// Todo: Essa classe não deveria conhecer o Json
class ClyoEngine internal constructor(
    private val json: Json,
    private val widgetFactory: WidgetFactory,
    private val containerFactory: ContainerFactory
) {
    fun create(context: Context, json: ContainerJson): Container<*> {
        val container = containerFactory.create(context, json.type)

        json.content.forEach { widgetJson ->
            container.add(widgetFactory.create(context, widgetJson.type))
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

class ClyoEngineBuilder {
    private lateinit var json: Json
    private lateinit var widgetFactory: ComponentFactory<out Widget<*, *>>
    private lateinit var componentFactory: ComponentFactory<out Container<*>>

    fun json(json: Json) = apply { this.json = json }
    fun widgetProvider(widgetFactory: ComponentFactory<out Widget<*, *>>) =
        apply { this.widgetFactory = widgetFactory }

    fun containerProvider(componentFactory: ComponentFactory<out Container<*>>) =
        apply { this.componentFactory = componentFactory }

    fun build() = ClyoEngine(json, widgetFactory, componentFactory)
}

fun clyoEngine(block: ClyoEngineBuilder.() -> Unit): ClyoEngine =
    ClyoEngineBuilder().apply(block).build()