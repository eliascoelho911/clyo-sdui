package com.clyo.core.data.kotlinx.serialization.data

import com.clyo.core.data.LayoutData
import com.clyo.core.data.ScreenData
import com.clyo.core.data.ViewData
import com.clyo.core.data.ViewName
import com.clyo.core.data.ViewProperties
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
    override val content: LayoutDataKS
) : ScreenData

@Serializable
data class LayoutDataKS(
    @SerialName("name")
    override val name: ViewName,
    @SerialName("properties")
    override val properties: ViewPropertiesKS = ViewPropertiesKS(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<ViewDataKS> = emptyList()
) : LayoutData


@Serializable
data class ViewDataKS(
    @SerialName("name")
    override val name: ViewName,
    @SerialName("properties")
    override val properties: ViewPropertiesKS = ViewPropertiesKS(JsonObject(mapOf()))
) : ViewData

@Serializable(with = ComponentPropertiesAsJsonObjectSerializer::class)
data class ViewPropertiesKS(
    val jsonObject: JsonObject
) : ViewProperties {
    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive
}