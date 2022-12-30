package com.clyo.core.data

interface WidgetData{
    val name: WidgetName
    val properties: WidgetProperties
    val content: List<WidgetData>
}