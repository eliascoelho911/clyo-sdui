package com.clyo.android.render

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.data.widget.getProperties
import com.clyo.tools.json.JsonProvider
import com.clyo.stubs.ClyoStub
import com.clyo.stubs.WidgetStub
import com.clyo.widget.TextProperties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class WidgetPropertyAssignorTest {
    private val view: AppCompatTextView = mockk(relaxed = true)

    @Test
    fun `should assign text properties to text view`() {
        // Given
        val widgetId = WidgetStub.Text.id
        val properties = ClyoStub.clyo.properties

        // When
        val assignor = TextPropertyAssignor(widgetId)

        assignor.assign(view, properties)

        // Then
        verify { view.text = properties.getProperties<TextProperties>(widgetId).text }
    }
}