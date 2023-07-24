package com.clyo.component.widget

import com.clyo.component.properties.Properties
import com.clyo.component.type.ComponentType
import com.clyo.component.type.serializer.ComponentTypeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetData(
    @SerialName("type")
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    @SerialName("args")
    val args: Properties
)