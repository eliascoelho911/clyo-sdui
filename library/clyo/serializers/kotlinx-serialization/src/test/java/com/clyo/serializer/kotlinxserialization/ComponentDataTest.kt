package com.clyo.serializer.kotlinxserialization

import com.clyo.serializer.kotlinxserialization.stub.ViewDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ComponentDataTest {
    @Test
    fun `Should deserialize ViewData`() {
        val deserializedValue = Json.decodeFromString<ComponentData>(ViewDataStub.jsonValue)
        val expected = ViewDataStub.viewData

        assertEquals(expected, deserializedValue)
    }
}