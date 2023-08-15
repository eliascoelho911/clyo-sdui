package com.clyo.component.json

import com.clyo.component.widget.widgets.TestWidgetProperties
import com.clyo.json.JsonInstanceFactory
import kotlinx.serialization.decodeFromString

private val json = JsonInstanceFactory.create(
    widgetPropertiesKSerializerMap = mapOf(
        TestWidgetProperties::class to TestWidgetProperties.serializer()
    )
)

internal inline fun <reified T> decode(jsonValue: String): T = json.decodeFromString(jsonValue)