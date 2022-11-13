package com.eliascoelho911.clyo

interface ScreenData {
    val content: ComponentData
}

typealias ComponentName = String

typealias ComponentProperties = Map<String, PropertyValue>

interface ComponentData {
    val name: ComponentName
    val properties: ComponentProperties
}

interface PropertyValue {
    val boolean: Boolean

    val booleanOrNull: Boolean?

    val float: Float

    val floatOrNull: Float?

    val double: Double

    val doubleOrNull: Double?

    val int: Int

    val intOrNull: Int?

    val long: Long

    val longOrNull: Long?

    val content: String

    val contentOrNull: String?
}