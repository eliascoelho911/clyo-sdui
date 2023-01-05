package com.clyo.data

@JvmInline
value class ComponentName(val name: String)

interface ComponentData {
    val name: ComponentName
    val properties: PropertiesData
}