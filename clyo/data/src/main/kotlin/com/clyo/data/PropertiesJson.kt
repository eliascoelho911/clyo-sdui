package com.clyo.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject

@Serializable(PropertiesJsonSerializer::class)
data class PropertiesJson(val content: JsonObject)

private object PropertiesJsonSerializer : KSerializer<PropertiesJson> {
    override val descriptor: SerialDescriptor = JsonObject.serializer().descriptor

    override fun serialize(encoder: Encoder, value: PropertiesJson) {
        encoder.encodeSerializableValue(JsonObject.serializer(), value.content)
    }

    override fun deserialize(decoder: Decoder): PropertiesJson {
        val json = decoder.decodeSerializableValue(JsonObject.serializer())
        return PropertiesJson(json)
    }
}