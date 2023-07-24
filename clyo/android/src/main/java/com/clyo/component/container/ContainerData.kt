package com.clyo.component.container

import com.clyo.component.widget.WidgetData
import com.clyo.component.type.ComponentType
import com.clyo.component.type.serializer.ComponentTypeSerializer
import kotlinx.serialization.Serializable

@Serializable
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    val content: List<WidgetData>
)