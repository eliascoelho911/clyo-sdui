package com.clyo.stubs

import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object PropertiesJsonStub {
    val propertiesJson = PropertiesJson(
        JsonObject(
            mapOf(
                "widget1" to JsonObject(
                    mapOf(
                        "type" to JsonPrimitive("widget1"),
                        "widget1_prop" to JsonPrimitive(true)
                    )
                ),
                "widget2" to JsonObject(
                    mapOf(
                        "type" to JsonPrimitive("widget2"),
                        "widget2_prop" to JsonPrimitive(true)
                    )
                ),
                "txt" to JsonObject(
                    mapOf(
                        "type" to JsonPrimitive("text"),
                        "text" to JsonPrimitive("test")
                    )
                ),
            )
        )
    )
}