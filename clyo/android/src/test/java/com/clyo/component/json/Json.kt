package com.clyo.component.json

import com.clyo.component.properties.WidgetProperties
import com.clyo.component.widget.widgets.TestWidgetProperties
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val json = Json {
    serializersModule = SerializersModule {
        polymorphic(WidgetProperties::class) {
            subclass(TestWidgetProperties::class, TestWidgetProperties.serializer())
        }
    }
}

internal inline fun <reified T> decode(jsonValue: String): T = json.decodeFromString(jsonValue)