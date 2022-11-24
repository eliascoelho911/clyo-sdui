package com.clyo.core.data.kotlinx.serialization.data.serializer

import com.clyo.core.data.kotlinx.serialization.data.ComponentPropertiesKS
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject

internal class ComponentPropertiesAsJsonObjectSerializer : KSerializer<ComponentPropertiesKS> {
    private val delegateSerializer = JsonObject.serializer()

    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = SerialDescriptor(
        serialName = "ComponentProperties",
        original = delegateSerializer.descriptor
    )

    override fun serialize(encoder: Encoder, value: ComponentPropertiesKS) {
        encoder.encodeSerializableValue(delegateSerializer, value.jsonObject)
    }

    override fun deserialize(decoder: Decoder): ComponentPropertiesKS {
        val jsonObject = decoder.decodeSerializableValue(delegateSerializer)
        return ComponentPropertiesKS(jsonObject)
    }
}