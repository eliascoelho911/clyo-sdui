package com.clyo.data

interface ScreenData {
    val content: LayoutData
}

interface LayoutData : ViewData {
    val content: List<ViewData>
}

interface ViewData {
    val name: ViewName
    val properties: ViewProperties
}

typealias ViewName = String

interface ViewProperties {
    fun getStringOrNull(key: String): String?

    fun getBooleanOrNull(key: String): Boolean?

    fun getDoubleOrNull(key: String): Double?

    fun getFloatOrNull(key: String): Float?

    fun getIntOrNull(key: String): Int?

    fun getLongOrNull(key: String): Long?
}