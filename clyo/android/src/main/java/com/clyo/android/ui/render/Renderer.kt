package com.clyo.android.ui.render

import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.component.container.Container
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

internal class Renderer(private val json: Json) {

    fun render(container: Container<*>, propertiesJson: PropertiesJson) {
        container.children.forEach { widget ->
            widget.render(propertiesJson.decodeProperties(json, widget.id))
        }
    }
}