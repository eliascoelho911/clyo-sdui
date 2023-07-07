package com.clyo.data

import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoJson(
    @SerialName("content")
    val content: List<WidgetJson>,
    @SerialName("properties")
    val properties: PropertiesJson
)
