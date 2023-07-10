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
    return runCatching {
        propertiesJson.content[widgetId]!!.jsonObject
    }.fold(
        onSuccess = { it },
        onFailure = {
            throw IllegalStateException("Properties for widget $widgetId not found")
        }
    )
}