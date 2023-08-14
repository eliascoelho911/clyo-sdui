package com.clyo.component.widget

import com.clyo.component.properties.WidgetProperties
import com.clyo.component.widget.widgets.TestWidgetProperties
import com.clyo.component.widget.widgets.TestWidgetStubs
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.junit.Assert.assertEquals
import org.junit.Test

internal class WidgetDataTest {
    @Test
    fun `test WidgetData serialization`() {
        val jsonValue = TestWidgetStubs.jsonValue
        val expected = TestWidgetStubs.widgetData

        assertEquals(decode<WidgetData>(jsonValue), expected)
    }
}

private val json = Json {
    ignoreUnknownKeys = true
    serializersModule = SerializersModule {
        polymorphic(WidgetProperties::class) {
            subclass(TestWidgetProperties::class, TestWidgetProperties.serializer())
        }
    }
}

private inline fun <reified T> decode(jsonValue: String): T = json.decodeFromString(jsonValue)
