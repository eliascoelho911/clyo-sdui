package com.clyo.tests

import com.clyo.data.json.ContainerJson
import com.clyo.stubs.ContainerStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class ContainerTest {

    @Test
    fun `should map a json to a ContainerJson`() {
        // Given
        val json = ContainerStub.jsonValue
        val expected = ContainerStub.container

        // When
        val result = Json.decodeFromString<ContainerJson>(json)

        // Then
        assertEquals(expected, result)
    }
}