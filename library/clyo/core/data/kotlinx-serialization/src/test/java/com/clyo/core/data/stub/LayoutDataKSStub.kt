package com.clyo.core.data.stub

import com.clyo.core.data.kotlinx.serialization.data.ComponentPropertiesKS
import com.clyo.core.data.kotlinx.serialization.data.ContainerDataKS
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object LayoutDataKSStub {

    val jsonValue = """
        {
          "name": "layout",
          "content": [
            ${ComponentDataStub.jsonValue}
          ],
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

    val layoutDataKS = ContainerDataKS(
        name = "layout",
        properties = ComponentPropertiesKS(
            JsonObject(
                mapOf(
                    "value" to JsonPrimitive(0), "array" to JsonArray(
                        listOf(
                            JsonPrimitive(0), JsonPrimitive(1)
                        )
                    ), "map" to JsonObject(
                        mapOf(
                            "zero" to JsonPrimitive(0)
                        )
                    )
                )
            )
        ), content = listOf(
            ComponentDataStub.viewDataKS
        )
    )
}