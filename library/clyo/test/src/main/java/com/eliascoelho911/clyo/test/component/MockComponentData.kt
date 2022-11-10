package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.data.ComponentDataContract
import com.eliascoelho911.clyo.data.ComponentName
import com.eliascoelho911.clyo.data.PropertyValue

data class MockComponentData(
    override val name: ComponentName,
    override val properties: Map<String, MockPropertyValue>
) : ComponentDataContract

data class MockPropertyValue(private val value: Any) : PropertyValue {
    override val boolean: Boolean get() = value as Boolean

    override val booleanOrNull: Boolean? get() = value as? Boolean

    override val float: Float get() = value as Float

    override val floatOrNull: Float? get() = value as? Float

    override val double: Double get() = value as Double

    override val doubleOrNull: Double? get() = value as? Double

    override val int: Int get() = value as Int

    override val intOrNull: Int? get() = value as? Int

    override val long: Long get() = value as Long

    override val longOrNull: Long? get() = value as? Long

    override val content: String get() = value as String

    override val contentOrNull: String? get() = value as? String
}