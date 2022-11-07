package com.eliascoelho911.notate.clyo.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ComponentData(
    @SerialName("type") val type: String,
    @SerialName("properties") val properties: JsonObject,
    @SerialName("onClickActions") val onClickActions: List<Action>
)
