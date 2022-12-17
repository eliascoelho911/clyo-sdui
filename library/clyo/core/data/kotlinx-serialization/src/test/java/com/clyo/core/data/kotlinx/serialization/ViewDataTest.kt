package com.clyo.core.data.kotlinx.serialization

import com.clyo.core.data.kotlinx.serialization.stub.ViewDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ViewDataTest {
    @Test
    fun `Should deserialize ComponentData`() {
        val deserializedValue = Json.decodeFromString<ViewData>(ViewDataStub.jsonValue)
        val expected = ViewDataStub.viewData

        assertEquals(expected, deserializedValue)
    }
}