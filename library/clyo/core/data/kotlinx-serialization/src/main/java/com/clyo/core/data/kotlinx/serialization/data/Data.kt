package com.clyo.core.data.kotlinx.serialization.data

import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ComponentProperties
import com.clyo.core.data.ContainerData
import com.clyo.core.data.ScreenData
import com.clyo.core.data.kotlinx.serialization.data.serializer.ComponentPropertiesAsJsonObjectSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

@Serializable
data class ScreenDataKS(
    @SerialName("content")
    override val content: ContainerDataKS
) : ScreenData

@Serializable
data class ContainerDataKS(
    @SerialName("name")
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: ComponentPropertiesKS = ComponentPropertiesKS(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<ComponentDataKS> = emptyList()
) : ContainerData


@Serializable
data class ComponentDataKS(
    @SerialName("name")
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: ComponentPropertiesKS = ComponentPropertiesKS(JsonObject(mapOf()))
) : ComponentData

@Serializable(with = ComponentPropertiesAsJsonObjectSerializer::class)
data class ComponentPropertiesKS(
    val jsonObject: JsonObject
) : ComponentProperties {
    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive
}