package com.clyo.android.util.serializer

import com.clyo.android.properties.PropertiesData
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject

internal class PropertiesAsJsonObjectSerializer : KSerializer<PropertiesData> {
    private val delegateSerializer = JsonObject.serializer()

    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = SerialDescriptor(
        serialName = "ComponentProperties",
        original = delegateSerializer.descriptor
    )

    override fun serialize(encoder: Encoder, value: PropertiesData) {
        encoder.encodeSerializableValue(delegateSerializer, value.jsonObject)
    }

    override fun deserialize(decoder: Decoder): PropertiesData {
        val jsonObject = decoder.decodeSerializableValue(delegateSerializer)
        return PropertiesData(jsonObject)
    }
}