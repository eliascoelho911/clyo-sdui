package com.clyo.tests

import com.clyo.data.layout.LayoutJson
import com.clyo.stubs.LayoutStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class LayoutTest {

    @Test
    fun `should map a json to a LayoutJson`() {
        // Given
        val json = LayoutStub.jsonValue
        val expected = LayoutStub.layout

        // When
        val result = Json.decodeFromString<LayoutJson>(json)

        // Then
        assertEquals(expected, result)
    }
}