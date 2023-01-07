package com.clyo.serializer.kotlinxserialization.stub

import com.clyo.data.ComponentName
import com.clyo.serializer.kotlinxserialization.ComponentData
import com.clyo.serializer.kotlinxserialization.PropertiesData
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object ComponentDataStub {
    val jsonValue = """
        {
          "name": "component",
          "properties": ${PropertiesDataStub.jsonValue}
        }
    """.trimIndent()

    val componentData = ComponentData(
        name = ComponentName("component"),
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