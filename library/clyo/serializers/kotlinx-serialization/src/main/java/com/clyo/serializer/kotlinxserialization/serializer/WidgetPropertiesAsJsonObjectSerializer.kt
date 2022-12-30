package com.clyo.serializer.kotlinxserialization.serializer

import com.clyo.serializer.kotlinxserialization.WidgetProperties
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject

internal class WidgetPropertiesAsJsonObjectSerializer : KSerializer<WidgetProperties> {
    private val delegateSerializer = JsonObject.serializer()

    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = SerialDescriptor(
        serialName = "ComponentProperties",
        original = delegateSerializer.descriptor
    )

    override fun serialize(encoder: Encoder, value: WidgetProperties) {
        encoder.encodeSerializableValue(delegateSerializer, value.jsonObject)
    }

    override fun deserialize(decoder: Decoder): WidgetProperties {
        val jsonObject = decoder.decodeSerializableValue(delegateSerializer)
        return WidgetProperties(jsonObject)
    }
}