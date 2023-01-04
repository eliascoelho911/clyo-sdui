package com.clyo.core.data

interface ContainerData {
    val id: ClyoId
    val properties: PropertiesData
    val content: List<WidgetData>
}