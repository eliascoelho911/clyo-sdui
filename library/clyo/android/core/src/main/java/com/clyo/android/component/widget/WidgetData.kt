package com.clyo.android.component.widget

import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentName
import com.clyo.android.properties.PropertiesData
import com.clyo.android.util.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface AbstractWidgetData : AbstractComponentData {
    val layoutProperties: PropertiesData
}

@Serializable
data class WidgetData(
    @SerialName("name")
    @Serializable(with = ComponentNameAsStringSerializer::class)
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf())),
    @SerialName("layout_properties")
    override val layoutProperties: PropertiesData
) : AbstractWidgetData