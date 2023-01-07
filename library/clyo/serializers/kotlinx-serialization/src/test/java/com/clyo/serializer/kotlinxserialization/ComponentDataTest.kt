package com.clyo.serializer.kotlinxserialization

import com.clyo.serializer.kotlinxserialization.stub.ComponentDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ComponentDataTest {
    @Test
    fun `Should deserialize ComponentData`() {
        val deserializedValue = Json.decodeFromString<ComponentData>(ComponentDataStub.jsonValue)
        val expected = ComponentDataStub.componentData

        assertEquals(expected, deserializedValue)
    }
}