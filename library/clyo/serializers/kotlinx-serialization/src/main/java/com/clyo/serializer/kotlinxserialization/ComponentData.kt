package com.clyo.serializer.kotlinxserialization

import com.clyo.data.ComponentName
import com.clyo.serializer.kotlinxserialization.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import com.clyo.data.ComponentData as IComponentData

@Serializable
data class ComponentData(
    @SerialName("name")
    @Serializable(with = ComponentNameAsStringSerializer::class)
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf()))
) : IComponentData


