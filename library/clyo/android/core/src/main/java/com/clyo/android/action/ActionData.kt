package com.clyo.android.action

import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface AbstractActionData {
    val name: String
    val properties: AbstractPropertiesData
}

@Serializable
data class ActionData(
    @SerialName("name")
    override val name: String,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf()))
): AbstractActionData