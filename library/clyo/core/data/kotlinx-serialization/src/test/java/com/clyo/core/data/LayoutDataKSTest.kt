package com.clyo.core.data

import com.clyo.core.data.kotlinx.serialization.data.LayoutDataKS
import com.clyo.core.data.stub.LayoutDataKSStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class LayoutDataKSTest {
    @Test
    fun `Should deserialize LayoutData`() {
        val deserializedValue = Json.decodeFromString<LayoutDataKS>(LayoutDataKSStub.jsonValue)
        val expected = LayoutDataKSStub.layoutDataKS

        assertEquals(expected, deserializedValue)
    }
}