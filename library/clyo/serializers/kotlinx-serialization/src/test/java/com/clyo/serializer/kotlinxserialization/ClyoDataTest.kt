package com.clyo.serializer.kotlinxserialization

import com.clyo.serializer.kotlinxserialization.stub.ClyoDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ClyoDataTest {
    @Test
    fun `Should deserialize ClyoData`() {
        val deserializedValue = Json.decodeFromString<ClyoData>(ClyoDataStub.jsonValue)
        val expected = ClyoDataStub.clyoData

        assertEquals(expected, deserializedValue)
    }
}