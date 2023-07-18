package com.clyo.android.common.properties

import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import kotlin.test.assertIs
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.junit.Test

internal class PropertiesJsonExtKtTest {
    private val json: Json = Json {
        ignoreUnknownKeys = true
        serializersModule = SerializersModule {
            polymorphic(Properties::class) {
                subclass(Widget1Properties::class, Widget1Properties.serializer())
                subclass(Widget2Properties::class, Widget2Properties.serializer())
            }
        }
    }


    @Test
    fun `should get properties from json`() {
        // Given
        val propertiesJson = PropertiesJsonStub.propertiesJson

        // When
        val result = propertiesJson.decodeProperties(json, widgetId = "widget1")

        // Then
        assertIs<Widget1Properties>(result)
    }
}

@Serializable
@SerialName("widget1")
private data class Widget1Properties(
    @SerialName("widget1_prop")
    val prop: Boolean
) : Properties()

@Serializable
@SerialName("widget2")
private data class Widget2Properties(
    @SerialName("widget2_prop")
    val prop: Boolean
) : Properties()

private object PropertiesJsonStub {
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
                )
            )
        )
    )
}
