package com.clyo.test

import kotlin.test.assertEquals
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.junit.Test

internal class WidgetTest {
    @Test
    fun `Should map a PropertiesJson to a WidgetProperties`() {
        // Given
        val json = Stubs.textPropertiesJson
        val expected = Stubs.textProperties

        // When
        val result = Json.decodeFromJsonElement<TextProperties>(json)

        // Then
        assertEquals(expected, result)
    }
}
