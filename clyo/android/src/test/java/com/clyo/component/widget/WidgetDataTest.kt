package com.clyo.component.widget

import com.clyo.component.json.decode
import com.clyo.component.widget.widgets.TestWidgetStubs
import org.junit.Assert.assertEquals
import org.junit.Test

internal class WidgetDataTest {

    @Test
    fun `test WidgetData serialization`() {
        val jsonValue = TestWidgetStubs.jsonValue
        val expected = TestWidgetStubs.widgetData

        assertEquals(decode<WidgetData>(jsonValue), expected)
    }
}