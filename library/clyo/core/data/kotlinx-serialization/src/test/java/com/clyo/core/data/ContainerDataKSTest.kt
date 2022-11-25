package com.clyo.core.data

import com.clyo.core.data.kotlinx.serialization.data.ContainerDataKS
import com.clyo.core.data.stub.LayoutDataKSStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class ContainerDataKSTest {
    @Test
    fun `Should deserialize LayoutData`() {
        val deserializedValue = Json.decodeFromString<ContainerDataKS>(LayoutDataKSStub.jsonValue)
        val expected = LayoutDataKSStub.layoutDataKS

        assertEquals(expected, deserializedValue)
    }
}