package com.clyo.core.data

interface PropertiesData {
    fun getStringOrNull(key: String): String?

    fun getBooleanOrNull(key: String): Boolean?

    fun getDoubleOrNull(key: String): Double?

    fun getFloatOrNull(key: String): Float?

    fun getIntOrNull(key: String): Int?

    fun getLongOrNull(key: String): Long?
}