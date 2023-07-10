package com.clyo.data.container

import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerJson(
    @SerialName("type")
    val type: String,
    @SerialName("content")
    val content: List<WidgetJson>
)
