package com.clyo.android.common.properties

import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

internal fun PropertiesJson.decodeProperties(
    json: Json,
    widgetId: String,
): Properties {
    val jsonObject = propertiesObject(this, widgetId)

    return json.decodeFromJsonElement(jsonObject)
}

private fun propertiesObject(
    propertiesJson: PropertiesJson,
    widgetId: String
): JsonObject {
    return propertiesJson.content[widgetId]?.jsonObject ?: throw IllegalArgumentException(
        "No properties for widget $widgetId"
    )
}