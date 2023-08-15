package com.clyo.component.widget

import com.clyo.component.properties.WidgetProperties
import com.clyo.component.type.ComponentType
import com.clyo.component.type.ComponentTypeSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = WidgetDataJsonTransformingSerializer::class)
data class WidgetData(
    @SerialName("#widget")
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,

    @SerialName("properties")
    val properties: WidgetProperties
)

internal object WidgetDataJsonTransformingSerializer :
    JsonTransformingSerializer<WidgetData>(WidgetDataSerializer) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        val type = element.jsonObject["#widget"]!!.jsonPrimitive.content
        val onlyProperties = element.jsonObject.filter { !it.key.startsWith("#") }
        val propertiesWithType = onlyProperties + ("#widget" to JsonPrimitive(type))

        return buildJsonObject {
            put("#widget", JsonPrimitive(type))
            put("properties", JsonObject(propertiesWithType))
        }
    }
}

private object WidgetDataSerializer : KSerializer<WidgetData> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("WidgetData") {
        element("#widget", ComponentTypeSerializer.descriptor)
        element("properties", WidgetProperties.serializer().descriptor)
    }

    override fun deserialize(decoder: Decoder): WidgetData {
        val compositeDecoder = decoder.beginStructure(descriptor)

        return WidgetData(
            type = compositeDecoder.decodeSerializableElement(
                descriptor = descriptor,
                index = 0,
                deserializer = ComponentTypeSerializer
            ),
            properties = compositeDecoder.decodeSerializableElement(
                descriptor = descriptor,
                index = 1,
                deserializer = WidgetProperties.serializer()
            )
        )
    }

    override fun serialize(encoder: Encoder, value: WidgetData) {
        encoder.encodeSerializableValue(ComponentTypeSerializer, value.type)
        encoder.encodeSerializableValue(WidgetProperties.serializer(), value.properties)
    }
}