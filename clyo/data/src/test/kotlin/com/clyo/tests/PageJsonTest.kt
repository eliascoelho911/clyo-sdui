package com.clyo.tests

import com.clyo.data.PageJson
import com.clyo.stubs.PageJsonStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class PageJsonTest {
    @Test
    fun `Should map a PageJson to a Clyo`() {
        // Given
        val json = PageJsonStub.jsonValue
        val expected = PageJsonStub.json

        // When
        val result = Json.decodeFromString<PageJson>(json)

        // Then
        assertEquals(expected, result)
    }
}