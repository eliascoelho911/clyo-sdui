package com.clyo.data

import com.clyo.data.layout.LayoutJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConsolidatedJson(
    @SerialName("content")
    val content: LayoutJson,
    @SerialName("properties")
    val properties: PropertiesJson
)
