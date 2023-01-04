package com.clyo.serializer.kotlinxserialization.stub

import com.clyo.serializer.kotlinxserialization.PropertiesData
import com.clyo.serializer.kotlinxserialization.WidgetData
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object ViewDataStub {
    val jsonValue = """
        {
          "name": "component",
          "properties": {
            "value": 0,
            "array": [
              0,
              1
            ],
            "map": {
              "zero": 0
            }
          }
        }
    """.trimIndent()

    val viewData = WidgetData(
        id = "component",
        properties = PropertiesData(
            JsonObject(
                mapOf(
                    "value" to JsonPrimitive(0),
                    "array" to JsonArray(
                        listOf(
                            JsonPrimitive(0),
                            JsonPrimitive(1)
                        )
                    ),
                    "map" to JsonObject(
                        mapOf(
                            "zero" to JsonPrimitive(0)
                        )
                    )
                )
            )
        )
    )
}