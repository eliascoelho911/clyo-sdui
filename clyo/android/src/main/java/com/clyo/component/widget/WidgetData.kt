package com.clyo.component.widget

import com.clyo.component.properties.WidgetProperties
import com.clyo.component.type.ComponentType
import com.clyo.component.type.serializer.ComponentTypeSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetData(
    @SerialName("type")
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,

    @SerialName("properties")
    val properties: WidgetProperties
)