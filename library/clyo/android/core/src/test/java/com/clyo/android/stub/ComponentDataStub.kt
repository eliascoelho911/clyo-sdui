package com.clyo.android.stub

import com.clyo.android.component.ComponentData
import com.clyo.android.component.ComponentName
import com.clyo.android.properties.PropertiesData
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