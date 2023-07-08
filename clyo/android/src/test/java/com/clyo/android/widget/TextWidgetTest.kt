package com.clyo.android.widget

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.data.widget.getProperties
import com.clyo.stubs.ConsolidatedJsonStub
import com.clyo.stubs.WidgetStub
import com.clyo.widget.TextProperties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class TextWidgetTest {
    private val view: AppCompatTextView = mockk(relaxed = true)

    @Test
    fun `should assign text properties to text view`() {
        // Given
        val widgetId = WidgetStub.Text.id
        val properties = ConsolidatedJsonStub.json.properties
        val assignor = TextBinder(widgetId)

        // When
        assignor.assign(view, properties)

        // Then
        verify { view.text = properties.getProperties<TextProperties>(widgetId).text }
    }

    @Test
    fun `should render text widget`() {
        // Given
        val widgetJson = WidgetStub.Text.widgetJson
        val properties = ConsolidatedJsonStub.json.properties
        val binder = TextBinder(widgetJson.id)
        val view = mockk<AppCompatTextView>(relaxed = true)
        val widget = Widget(view, binder)

        // When
        widget.render(properties)

        // Then
        verify { view.text = properties.getProperties<TextProperties>(widgetJson.id).text }
    }
}