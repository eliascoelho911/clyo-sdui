package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.ViewName
import com.clyo.serializer.kotlinxserialization.serializer.ViewPropertiesAsJsonObjectSerializer
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
import com.clyo.core.data.ClyoData as IClyoData
import com.clyo.core.data.ViewData as IViewData
import com.clyo.core.data.ViewProperties as IViewProperties

@Serializable
data class ClyoData(
    @SerialName("content")
    override val content: IViewData
) : IClyoData

@Serializable
data class ViewData(
    @SerialName("name")
    override val name: ViewName,
    @SerialName("properties")
    override val properties: IViewProperties = ViewProperties(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<IViewData> = emptyList()
) : IViewData


@Serializable(with = ViewPropertiesAsJsonObjectSerializer::class)
data class ViewProperties(
    val jsonObject: JsonObject
) : IViewProperties {
    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive
}