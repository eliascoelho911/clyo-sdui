package com.clyo.android.action

import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.properties.PropertiesData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface BaseActionsData {
    val onClick: List<BaseActionData>
    val onInit: List<BaseActionData>
}

interface BaseActionData {
    val name: String
    val properties: BasePropertiesData
}

@Serializable
data class ActionsData(
    @SerialName("on_click")
    override val onClick: List<ActionData> = listOf(),
    @SerialName("on_init")
    override val onInit: List<ActionData> = listOf()
) : BaseActionsData

@Serializable
data class ActionData(
    @SerialName("name")
    override val name: String,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf()))
) : BaseActionData