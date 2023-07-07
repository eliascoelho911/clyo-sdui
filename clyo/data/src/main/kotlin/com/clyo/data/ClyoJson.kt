package com.clyo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoJson(
    @SerialName("content")
    val content: WidgetJson,
    @SerialName("properties")
    val properties: PropertiesJson
)
