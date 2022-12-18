package com.clyo.data.kotlinx.serialization

import com.clyo.data.kotlinx.serialization.stub.ViewDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ViewDataTest {
    @Test
    fun `Should deserialize ViewData`() {
        val deserializedValue = Json.decodeFromString<ViewData>(ViewDataStub.jsonValue)
        val expected = ViewDataStub.viewData

        assertEquals(expected, deserializedValue)
    }
}