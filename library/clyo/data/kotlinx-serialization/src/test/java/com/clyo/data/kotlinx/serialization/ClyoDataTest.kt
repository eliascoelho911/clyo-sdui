package com.clyo.data.kotlinx.serialization

import com.clyo.data.kotlinx.serialization.stub.ScreenDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ClyoDataTest {
    @Test
    fun `Should deserialize ScreenData`() {
        val deserializedValue = Json.decodeFromString<ClyoData>(ScreenDataStub.jsonValue)
        val expected = ScreenDataStub.screenData

        assertEquals(expected, deserializedValue)
    }
}