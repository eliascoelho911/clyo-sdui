package com.clyo.android.util.serializer

import com.clyo.android.component.ComponentName
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class ComponentNameAsStringSerializer : KSerializer<ComponentName> {
    private val delegateSerializer = String.serializer()

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "ComponentName",
        kind = PrimitiveKind.STRING
    )

    override fun serialize(encoder: Encoder, value: ComponentName) {
        encoder.encodeSerializableValue(delegateSerializer, value.name)
    }

    override fun deserialize(decoder: Decoder): ComponentName {
        val name = decoder.decodeSerializableValue(delegateSerializer)
        return ComponentName(name)
    }
}