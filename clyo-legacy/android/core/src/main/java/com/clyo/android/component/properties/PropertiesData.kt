package com.clyo.android.component.properties

import android.graphics.Color
import androidx.annotation.ColorInt
import com.clyo.android.util.serializer.PropertiesAsJsonObjectSerializer
import java.util.regex.Pattern
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

//TODO [IMPORTANTE] Mudar para dataclass por widget. Isso permitirá a execução de testes de contrato
sealed interface BasePropertiesData {
    fun getString(key: String): String

    fun getStringOrNull(key: String): String?

    fun getBoolean(key: String): Boolean

    fun getBooleanOrNull(key: String): Boolean?

    fun getDouble(key: String): Double

    fun getDoubleOrNull(key: String): Double?

    fun getFloat(key: String): Float

    fun getFloatOrNull(key: String): Float?

    fun getInt(key: String): Int

    fun getIntOrNull(key: String): Int?

    fun getIntMap(key: String): Map<String, Int>

    fun getLong(key: String): Long

    fun getLongOrNull(key: String): Long?

    @ColorInt
    fun getColor(key: String): Int

    @ColorInt
    fun getColorOrNull(key: String): Int?
}

@Serializable(with = PropertiesAsJsonObjectSerializer::class)
data class PropertiesData(
    internal val jsonObject: JsonObject
) : BasePropertiesData {
    override fun getString(key: String): String = getStringOrNull(key) ?: error(key, "string")

    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBoolean(key: String): Boolean = getBooleanOrNull(key) ?: error(key, "boolean")

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDouble(key: String): Double = getDoubleOrNull(key) ?: error(key, "double")

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloat(key: String): Float = getFloatOrNull(key) ?: error(key, "float")

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getInt(key: String): Int = getIntOrNull(key) ?: error(key, "int")

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getIntMap(key: String): Map<String, Int> {
        return jsonObject[key]?.jsonObject?.toMap()?.mapValues {
            //TODO Melhorar mensagem de erro
            runCatching {
                it.value.jsonPrimitive.int
            }.getOrThrow()
        }.orEmpty()
    }

    override fun getLong(key: String): Long = getLongOrNull(key) ?: error(key, "long")

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    override fun getColor(key: String): Int = getColorOrNull(key) ?: error(key, "color")

    override fun getColorOrNull(key: String): Int? {
        val colorString = getStringOrNull(key) ?: return null

        if (!Pattern.matches(COLOR_REG, colorString)) {
            throw IllegalArgumentException("value $colorString is not valid hex color")
        }

        return Color.parseColor(colorString)
    }

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive

    private fun error(key: String, type: String): Nothing {
        throw IllegalArgumentException("No argument with key $key and type $type found")
    }
}

fun propertiesData(map: Map<String, JsonElement> = emptyMap()) = PropertiesData(JsonObject(map))

private const val COLOR_REG = "#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})\$"