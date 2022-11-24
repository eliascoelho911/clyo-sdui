package com.clyo.core.data

import com.clyo.core.data.kotlinx.serialization.data.ComponentDataKS
import com.clyo.core.data.stub.ComponentDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ComponentDataKSTest {
    @Test
    fun `Should deserialize ComponentData`() {
        val deserializedValue = Json.decodeFromString<ComponentDataKS>(ComponentDataStub.jsonValue)
        val expected = ComponentDataStub.componentDataKS

        assertEquals(expected, deserializedValue)
    }
}