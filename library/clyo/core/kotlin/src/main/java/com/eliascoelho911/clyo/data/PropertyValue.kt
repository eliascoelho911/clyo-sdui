package com.eliascoelho911.clyo.data

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