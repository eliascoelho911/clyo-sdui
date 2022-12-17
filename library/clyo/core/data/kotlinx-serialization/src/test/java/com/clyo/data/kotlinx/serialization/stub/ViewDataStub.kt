package com.clyo.core.data.kotlinx.serialization.stub

import com.clyo.core.data.kotlinx.serialization.ViewData
import com.clyo.core.data.kotlinx.serialization.ViewProperties
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