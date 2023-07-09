package com.clyo.stubs

import com.clyo.data.ConsolidatedJson
import com.clyo.data.layout.LayoutJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

internal object ConsolidatedJsonStub {
    val jsonValue = """
        {
            "content": {
                "type": "layout",
                "content": [
                    ${WidgetStub.Text.widgetJsonValue},
                    ${WidgetStub.Button.widgetJsonValue}
                ]
            },
            "properties": {
                "txt": ${WidgetStub.Text.propertiesJsonValue},
                "btn": ${WidgetStub.Button.propertiesJsonValue}
            }
        }
    """.trimIndent()

    val json = ConsolidatedJson(
        content = LayoutJson(
            type = "layout",
            content = listOf(
                WidgetStub.Text.widgetJson,
                WidgetStub.Button.widgetJson
            )
        ),
        properties = PropertiesJson(
            JsonObject(
                mapOf(
                    "txt" to Json.decodeFromString(WidgetStub.Text.propertiesJsonValue),
                    "btn" to Json.decodeFromString(WidgetStub.Button.propertiesJsonValue)
                )
            )
        )
    )
}