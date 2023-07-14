package com.clyo.data

import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoPageJson(
    @SerialName("content")
    val content: ContainerJson,
    @SerialName("properties")
    val properties: PropertiesJson
)
