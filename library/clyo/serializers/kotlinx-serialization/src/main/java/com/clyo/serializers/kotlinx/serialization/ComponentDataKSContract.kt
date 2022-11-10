package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.data.ComponentDataContract
import com.eliascoelho911.clyo.data.PropertyValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.float
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.long
import kotlinx.serialization.json.longOrNull

interface ComponentDataKSContract : ComponentDataContract {
    override val properties: Map<String, PropertyValueKS>
}

@Serializable
class PropertyValueKS(private val jsonPrimitive: JsonPrimitive) : PropertyValue {
    override val boolean: Boolean get() = jsonPrimitive.boolean

    override val booleanOrNull: Boolean? get() = jsonPrimitive.booleanOrNull

    override val float: Float get() = jsonPrimitive.float

    override val floatOrNull: Float? get() = jsonPrimitive.floatOrNull

    override val double: Double get() = jsonPrimitive.double

    override val doubleOrNull: Double? get() = jsonPrimitive.doubleOrNull

    override val int: Int get() = jsonPrimitive.int

    override val intOrNull: Int? get() = jsonPrimitive.intOrNull

    override val long: Long get() = jsonPrimitive.long

    override val longOrNull: Long? get() = jsonPrimitive.longOrNull

    override val content: String get() = jsonPrimitive.content

    override val contentOrNull: String? get() = jsonPrimitive.contentOrNull
}