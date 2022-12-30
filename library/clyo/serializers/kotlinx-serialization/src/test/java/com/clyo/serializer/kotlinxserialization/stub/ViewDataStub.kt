package com.clyo.serializer.kotlinxserialization.stub

import com.clyo.serializer.kotlinxserialization.ViewData
import com.clyo.serializer.kotlinxserialization.ViewProperties
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

    val viewData = ViewData(
        name = "component",
        properties = ViewProperties(
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