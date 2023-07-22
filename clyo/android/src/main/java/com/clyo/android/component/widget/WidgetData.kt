package com.clyo.android.component.widget

import com.clyo.android.component.args.ComponentArgs
import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.type.serializer.ComponentTypeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetData(
    @SerialName("type")
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    @SerialName("args")
    val args: ComponentArgs
)
