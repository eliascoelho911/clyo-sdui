package com.clyo.core.data

import com.clyo.core.data.kotlinx.serialization.data.ScreenDataKS
import com.clyo.core.data.stub.ScreenDataKSStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ScreenDataKSTest {
    @Test
    fun `Should deserialize ScreenData`() {
        val deserializedValue = Json.decodeFromString<ScreenDataKS>(ScreenDataKSStub.jsonValue)
        val expected = ScreenDataKSStub.screenDataKS

        assertEquals(expected, deserializedValue)
    }
}