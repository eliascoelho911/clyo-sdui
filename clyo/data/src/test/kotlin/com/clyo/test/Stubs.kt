package com.clyo.test

import com.clyo.data.ClyoJson
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.WidgetJson
import com.clyo.data.widget.WidgetProperties
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject

internal object Stubs {
    val clyoJson = ClyoJson(
        content = WidgetJson(
            type = "text",
            id = "txt"
        ),
        properties = PropertiesJson(
            JsonObject(
                mapOf(
                    "txt" to JsonObject(
                        mapOf("text" to JsonPrimitive("test"))
                    )
                )
            )
        )
    )

    val textPropertiesJson = clyoJson.properties.content["txt"]!!.jsonObject

    val textProperties = TextProperties(text = "test")
}


@Serializable
internal data class TextProperties(val text: String) : WidgetProperties()