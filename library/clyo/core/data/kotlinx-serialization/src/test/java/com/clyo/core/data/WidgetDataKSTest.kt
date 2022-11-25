package com.clyo.core.data

import com.clyo.core.data.kotlinx.serialization.data.WidgetDataKS
import com.clyo.core.data.stub.ComponentDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class WidgetDataKSTest {
    @Test
    fun `Should deserialize ComponentData`() {
        val deserializedValue = Json.decodeFromString<WidgetDataKS>(ComponentDataStub.jsonValue)
        val expected = ComponentDataStub.viewDataKS

        assertEquals(expected, deserializedValue)
    }
}