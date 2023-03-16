package com.clyo.android.component.container

import com.clyo.android.action.ActionsData
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.ComponentName
import com.clyo.android.component.properties.PropertiesData
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.util.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface BaseContainerData : BaseComponentData {
    val content: List<WidgetData>
}

@Serializable
data class ContainerData(
    @SerialName("container_name")
    @Serializable(ComponentNameAsStringSerializer::class)
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<WidgetData> = emptyList(),
    @SerialName("actions")
    override val actions: ActionsData = ActionsData()
) : BaseContainerData