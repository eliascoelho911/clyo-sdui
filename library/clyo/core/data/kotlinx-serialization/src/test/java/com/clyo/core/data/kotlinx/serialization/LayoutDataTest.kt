package com.clyo.core.data.kotlinx.serialization

import com.clyo.core.data.kotlinx.serialization.stub.LayoutDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class LayoutDataTest {
    @Test
    fun `Should deserialize LayoutData`() {
        val deserializedValue = Json.decodeFromString<LayoutData>(LayoutDataStub.jsonValue)
        val expected = LayoutDataStub.layoutData

        assertEquals(expected, deserializedValue)
    }
}