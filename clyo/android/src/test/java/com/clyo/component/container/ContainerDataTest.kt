package com.clyo.component.container

import com.clyo.component.json.decode
import kotlin.test.assertEquals
import org.junit.Test

internal class ContainerDataTest {

    @Test
    fun `test ContainerData serialization`() {
        val jsonValue = ContainerDataStub.jsonValue
        val expected = ContainerDataStub.container

        assertEquals(decode(jsonValue), expected)
    }
}