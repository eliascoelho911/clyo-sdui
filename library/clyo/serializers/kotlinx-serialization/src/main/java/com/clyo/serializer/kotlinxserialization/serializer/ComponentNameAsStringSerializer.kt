package com.clyo.serializer.kotlinxserialization.serializer

import com.clyo.data.ComponentName
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class ComponentNameAsStringSerializer : KSerializer<ComponentName> {
    private val delegateSerializer = String.serializer()

    @OptIn(ExperimentalSerializationApi::class)
    override val descriptor: SerialDescriptor = SerialDescriptor(
        serialName = "ComponentName",
        original = delegateSerializer.descriptor
    )

    override fun serialize(encoder: Encoder, value: ComponentName) {
        encoder.encodeSerializableValue(delegateSerializer, value.name)
    }

    override fun deserialize(decoder: Decoder): ComponentName {
        val name = decoder.decodeSerializableValue(delegateSerializer)
        return ComponentName(name)
    }
}