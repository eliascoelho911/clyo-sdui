package com.clyo.data.layout

import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LayoutJson(
    @SerialName("type")
    val type: String,
    @SerialName("content")
    val content: List<WidgetJson>
)
