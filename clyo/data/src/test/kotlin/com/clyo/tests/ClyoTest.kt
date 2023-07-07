package com.clyo.tests

import com.clyo.data.ClyoJson
import com.clyo.stubs.ClyoStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class ClyoTest {
    @Test
    fun `Should map a ClyoJson to a Clyo`() {
        // Given
        val json = ClyoStub.clyoJsonValue
        val expected = ClyoStub.clyo

        // When
        val result = Json.decodeFromString<ClyoJson>(json)

        // Then
        assertEquals(expected, result)
    }
}