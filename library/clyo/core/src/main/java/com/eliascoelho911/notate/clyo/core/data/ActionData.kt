package com.eliascoelho911.notate.clyo.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ActionData(
    @SerialName("type")
    val type: String,
    @SerialName("metadata")
    val metadata: JsonObject
)