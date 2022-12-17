package com.clyo.core.data.kotlinx.serialization

import com.clyo.core.data.kotlinx.serialization.stub.ScreenDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ScreenDataTest {
    @Test
    fun `Should deserialize ScreenData`() {
        val deserializedValue = Json.decodeFromString<ScreenData>(ScreenDataStub.jsonValue)
        val expected = ScreenDataStub.screenData

        assertEquals(expected, deserializedValue)
    }
}