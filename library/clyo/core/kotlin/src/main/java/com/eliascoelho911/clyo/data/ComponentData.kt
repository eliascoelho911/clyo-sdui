package com.eliascoelho911.clyo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable
data class ComponentData(
    @SerialName("key") val key: String,
    @SerialName("properties") val properties: Map<String, JsonPrimitive>
) {
    inline fun <reified T : Any> getPropertyByKey(key: String): T {
        val propertyValue = properties[key] ?: error("Property with key $key not found")
        return Json.decodeFromJsonElement(propertyValue)
    }
}