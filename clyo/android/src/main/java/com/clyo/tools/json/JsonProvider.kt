package com.clyo.tools.json

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

@PublishedApi
internal object JsonProvider {
    private var json: Json? = null

    fun get() = getOrCreate()

    fun create(serializersModule: SerializersModule? = null): Json {
        val newJson = Json {
            if (serializersModule != null) {
                this.serializersModule = serializersModule
            }
        }

        json = newJson

        return newJson
    }

    private fun getOrCreate(): Json {
        return json ?: create()
    }
}