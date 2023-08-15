package com.clyo.component.container

import com.clyo.component.type.ComponentType
import com.clyo.component.type.ComponentTypeSerializer
import com.clyo.component.widget.WidgetData
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("#type")
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    @SerialName("#type")
    val type: ComponentType,

    @Serializable
    @SerialName("#content")
    val content: List<WidgetData>
)