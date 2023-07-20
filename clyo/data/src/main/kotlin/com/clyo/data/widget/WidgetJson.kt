package com.clyo.data.widget

import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetJson(
    @SerialName("type")
    val type: String,
    @SerialName("properties")
    override val properties: PropertiesJson
) : WidgetData