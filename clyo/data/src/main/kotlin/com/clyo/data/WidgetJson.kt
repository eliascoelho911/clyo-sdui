package com.clyo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetJson(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String
)