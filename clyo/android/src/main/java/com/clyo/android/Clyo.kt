package com.clyo.android

import android.content.Context
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ext.container
import com.clyo.android.ui.Container
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson

class Clyo internal constructor() {
    fun create(context: Context, containerJson: ContainerJson): Container<*> {
        return container(context, containerJson)
    }

    fun render(container: Container<*>, propertiesJson: PropertiesJson) {
        container.children.forEach { widget ->
            val properties = propertiesJson.decodeProperties(json, widget.id)
            widget.render(properties)
        }
    }
}