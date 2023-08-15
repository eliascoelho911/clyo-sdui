package com.clyo.component.container

import com.clyo.component.type.ComponentType
import com.clyo.component.type.ComponentTypeSerializer
import com.clyo.component.widget.WidgetData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    @SerialName("#container")
    val type: ComponentType,

    @Serializable
    @SerialName("content")
    val content: List<WidgetData>
)