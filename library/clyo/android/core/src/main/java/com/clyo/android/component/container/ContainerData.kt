package com.clyo.android.component.container

import com.clyo.android.action.ActionData
import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentName
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.properties.PropertiesData
import com.clyo.android.util.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface AbstractContainerData : AbstractComponentData {
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
    @SerialName("on_click_actions")
    override val onClickActions: List<ActionData> = emptyList()
) : AbstractContainerData