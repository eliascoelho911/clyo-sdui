package com.clyo.android.component.container

import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.type.serializer.ComponentTypeSerializer
import com.clyo.android.component.widget.WidgetData
import kotlinx.serialization.Serializable

@Serializable
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    val content: List<WidgetData>
)