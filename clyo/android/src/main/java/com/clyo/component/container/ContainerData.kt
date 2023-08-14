package com.clyo.component.container

import com.clyo.component.type.ComponentType
import com.clyo.component.type.serializer.ComponentTypeSerializer
import com.clyo.component.widget.WidgetData
import kotlinx.serialization.Serializable

@Serializable
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,

    @Serializable
    val content: List<WidgetData>
)