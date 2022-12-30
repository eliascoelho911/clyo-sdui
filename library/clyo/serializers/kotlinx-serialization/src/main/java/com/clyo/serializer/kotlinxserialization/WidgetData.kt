package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.WidgetName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import com.clyo.core.data.WidgetData as IWidgetData
import com.clyo.core.data.WidgetProperties as IWidgetProperties

@Serializable
data class WidgetData(
    @SerialName("name")
    override val name: WidgetName,
    @SerialName("properties")
    override val properties: IWidgetProperties = WidgetProperties(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<IWidgetData> = emptyList()
) : IWidgetData


