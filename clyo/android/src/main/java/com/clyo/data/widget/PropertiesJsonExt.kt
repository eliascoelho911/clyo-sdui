package com.clyo.data.widget

import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import com.clyo.tools.json.JsonProvider
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

internal fun PropertiesJson.getProperties(
    widgetId: String
): Properties {
    val jsonObject = content[widgetId]?.jsonObject ?: throw IllegalArgumentException(
        "No properties for widget $widgetId"
    )

    return JsonProvider.get().decodeFromJsonElement(jsonObject)
}