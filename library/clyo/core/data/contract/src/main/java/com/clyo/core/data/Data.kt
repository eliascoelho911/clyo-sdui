package com.clyo.core.data

interface ScreenData {
    val content: ContainerData
}

interface ContainerData : ComponentData {
    val content: List<ComponentData>
}

interface ComponentData {
    val name: ComponentName
    val properties: ComponentProperties
}

typealias ComponentName = String

interface ComponentProperties {
    fun getStringOrNull(key: String): String?

    fun getBooleanOrNull(key: String): Boolean?

    fun getDoubleOrNull(key: String): Double?

    fun getFloatOrNull(key: String): Float?

    fun getIntOrNull(key: String): Int?

    fun getLongOrNull(key: String): Long?
}