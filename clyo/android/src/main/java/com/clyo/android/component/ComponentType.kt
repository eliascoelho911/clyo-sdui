package com.clyo.android.component

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@JvmInline
value class ComponentType(val type: String)

internal object ComponentTypeSerializer : KSerializer<ComponentType> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ComponentType) {
        encoder.encodeString(value.type)
    }

    override fun deserialize(decoder: Decoder): ComponentType {
        return ComponentType(decoder.decodeString())
    }
}