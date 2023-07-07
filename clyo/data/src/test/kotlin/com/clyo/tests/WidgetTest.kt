package com.clyo.tests

import com.clyo.data.widget.WidgetJson
import com.clyo.widget.TextProperties
import com.clyo.stubs.WidgetStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

internal class WidgetTest {
    @Test
    fun `Should map a json to a WidgetProperties`() {
        // Given
        val json = WidgetStub.Text.propertiesJsonValue
        val expected = WidgetStub.Text.properties

        // When
        val result = Json.decodeFromString<TextProperties>(json)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `Should map a json to a WidgetJson`() {
        // Given
        val json = WidgetStub.Text.widgetJsonValue
        val expected = WidgetStub.Text.widgetJson

        // When
        val result = Json.decodeFromString<WidgetJson>(json)

        // Then
        assertEquals(expected, result)
    }
}
