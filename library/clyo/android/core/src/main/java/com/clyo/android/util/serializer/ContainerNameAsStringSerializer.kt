package com.clyo.android.util.serializer

import com.clyo.android.component.container.ContainerName
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class ContainerNameAsStringSerializer : KSerializer<ContainerName> {
    private val delegateSerializer = String.serializer()

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "ContainerName",
        kind = PrimitiveKind.STRING
    )

    override fun serialize(encoder: Encoder, value: ContainerName) {
        encoder.encodeSerializableValue(delegateSerializer, value.name)
    }

    override fun deserialize(decoder: Decoder): ContainerName {
        val name = decoder.decodeSerializableValue(delegateSerializer)
        return ContainerName(name)
    }
}