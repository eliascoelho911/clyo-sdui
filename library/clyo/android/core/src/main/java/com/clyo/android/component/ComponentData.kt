package com.clyo.android.component

import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesData
import com.clyo.android.util.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@JvmInline
value class ComponentName(val name: String)

interface AbstractComponentData {
    val name: ComponentName
    val properties: AbstractPropertiesData
}

@Serializable
data class ComponentData(
    @SerialName("name")
    @Serializable(with = ComponentNameAsStringSerializer::class)
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: AbstractPropertiesData = PropertiesData(JsonObject(mapOf()))
) : AbstractComponentData