package com.clyo.sample.impl

import com.clyo.android.component.ComponentArgs
import com.clyo.sample.components.widget.ButtonArgs
import com.clyo.sample.components.widget.TextArgs
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

internal val ClyoSampleJson = Json {
    ignoreUnknownKeys = true
    serializersModule = SerializersModule {
        polymorphic(ComponentArgs::class) {
            subclass(TextArgs::class, TextArgs.serializer())
            subclass(ButtonArgs::class, ButtonArgs.serializer())
        }
    }
}