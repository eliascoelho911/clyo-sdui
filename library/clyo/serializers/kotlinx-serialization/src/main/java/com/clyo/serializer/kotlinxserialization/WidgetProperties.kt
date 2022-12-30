package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.WidgetProperties
import com.clyo.serializer.kotlinxserialization.serializer.WidgetPropertiesAsJsonObjectSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

@Serializable(with = WidgetPropertiesAsJsonObjectSerializer::class)
data class WidgetProperties(
    val jsonObject: JsonObject
) : WidgetProperties {
    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive
}