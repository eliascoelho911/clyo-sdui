package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.ClyoId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import com.clyo.core.data.ContainerData as IContainerData
import com.clyo.core.data.PropertiesData as IWidgetProperties
import com.clyo.core.data.WidgetData as IWidgetData

@Serializable
data class ContainerData(
    @SerialName("id")
    override val id: ClyoId,
    @SerialName("properties")
    override val properties: IWidgetProperties = PropertiesData(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<IWidgetData> = emptyList()
) : IContainerData


