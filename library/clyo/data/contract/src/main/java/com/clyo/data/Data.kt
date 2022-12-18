package com.clyo.data

interface ScreenData {
    val content: ViewData
}

interface ViewData{
    val name: ViewName
    val properties: ViewProperties
    val content: List<ViewData>
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