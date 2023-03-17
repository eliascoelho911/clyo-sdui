package com.clyo.android.component.container.template

import com.clyo.android.component.properties.PropertiesData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface BaseClyoTemplateData {
    val name: String
    val rootName: String
    val content: List<BaseWidgetSlotData>
}

@Serializable
data class ClyoTemplateData(
    @SerialName("name")
    override val name: String,
    @SerialName("root")
    override val rootName: String,
    @SerialName("content")
    override val content: List<WidgetSlotData> = emptyList()
) : BaseClyoTemplateData

interface BaseWidgetSlotData {
    val ref: String
    val layoutProperties: PropertiesData
}

@Serializable
data class WidgetSlotData(
    @SerialName("ref")
    override val ref: String,
    @SerialName("layout_properties")
    override val layoutProperties: PropertiesData
) : BaseWidgetSlotData