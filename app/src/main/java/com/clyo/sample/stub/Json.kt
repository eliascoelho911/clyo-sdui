package com.clyo.sample.stub

import com.clyo.data.properties.Properties
import com.clyo.sample.components.widget.ButtonProperties
import com.clyo.sample.components.widget.TextProperties
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

internal val ClyoSampleJson = Json {
    ignoreUnknownKeys = true
    serializersModule = SerializersModule {
        polymorphic(Properties::class) {
            subclass(TextProperties::class, TextProperties.serializer())
            subclass(ButtonProperties::class, ButtonProperties.serializer())
        }
    }
}