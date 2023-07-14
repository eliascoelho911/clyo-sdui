package com.clyo.tests

import com.clyo.data.ClyoPageJson
import com.clyo.stubs.ConsolidatedJsonStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class ClyoPageJsonTest {
    @Test
    fun `Should map a ConsolidatedJson to a Clyo`() {
        // Given
        val json = ConsolidatedJsonStub.jsonValue
        val expected = ConsolidatedJsonStub.json

        // When
        val result = Json.decodeFromString<ClyoPageJson>(json)

        // Then
        assertEquals(expected, result)
    }
}