package com.clyo.android.action

import com.clyo.android.properties.BasePropertiesData
import com.clyo.android.properties.PropertiesData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface BaseActionData {
    val name: String
    val properties: BasePropertiesData
}

@Serializable
data class ActionData(
    @SerialName("name")
    override val name: String,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf()))
): BaseActionData