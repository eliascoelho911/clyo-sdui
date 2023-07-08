package com.clyo.tests

import com.clyo.data.ConsolidatedJson
import com.clyo.stubs.ConsolidatedJsonStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class ConsolidatedJsonTest {
    @Test
    fun `Should map a ConsolidatedJson to a Clyo`() {
        // Given
        val json = ConsolidatedJsonStub.jsonValue
        val expected = ConsolidatedJsonStub.json

        // When
        val result = Json.decodeFromString<ConsolidatedJson>(json)

        // Then
        assertEquals(expected, result)
    }
}