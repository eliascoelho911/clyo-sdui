package com.clyo.sample.stub

import com.clyo.data.PageJson
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object ClyoJsonStub {
    val json = PageJson(
        content = ContainerJson(
            type = "column",
            content = listOf(
                WidgetJson(type = "text", id = "txt"),
                WidgetJson(type = "button", id = "btn")
            )
        ),
        properties = PropertiesJson(
            JsonObject(
                mapOf(
                    "txt" to JsonObject(
                        mapOf(
                            "type" to JsonPrimitive("text"),
                            "text" to JsonPrimitive("test text")
                        )
                    ),
                    "btn" to JsonObject(
                        mapOf(
                            "type" to JsonPrimitive("button"),
                            "text" to JsonPrimitive("test button"),
                            "isEnabled" to JsonPrimitive(true)
                        )
                    )
                )
            )
        )
    )
}