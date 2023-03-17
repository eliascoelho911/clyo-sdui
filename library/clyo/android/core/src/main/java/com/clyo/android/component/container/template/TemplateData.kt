package com.clyo.android.component.container.template

import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.properties.PropertiesData
import com.clyo.android.component.properties.propertiesData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface BaseTemplateData {
    val name: String
    val rootName: String
    val content: List<BaseWidgetSlotData>
}

@Serializable
data class TemplateData(
    @SerialName("name")
    override val name: String,
    @SerialName("root")
    override val rootName: String,
    @SerialName("content")
    override val content: List<WidgetSlotData> = emptyList()
) : BaseTemplateData

interface BaseWidgetSlotData {
    val ref: String
    val layoutProperties: BasePropertiesData
}

@Serializable
data class WidgetSlotData(
    @SerialName("ref")
    override val ref: String,
    @SerialName("layout_properties")
    override val layoutProperties: PropertiesData = propertiesData()
) : BaseWidgetSlotData