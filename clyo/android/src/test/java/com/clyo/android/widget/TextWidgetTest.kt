package com.clyo.android.widget

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.impl.widget.TextBinder
import com.clyo.android.impl.widget.TextProperties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class TextWidgetTest {
    private val view: AppCompatTextView = mockk(relaxed = true)

    @Test
    fun `should assign text properties to text view`() {
        // Given
        val widgetId = "widgetId"
        val properties = TextProperties("text")
        val assignor = TextBinder(widgetId)

        // When
        assignor.bind(view, properties)

        // Then
        verify { view.text = properties.text }
    }

    @Test
    fun `should render text widget`() {
        // Given
        val widgetId = "widgetId"
        val properties = TextProperties("text")
        val binder = TextBinder(widgetId)
        val view = mockk<AppCompatTextView>(relaxed = true)
        val widget = Widget(view, binder)

        // When
        widget.render(properties)

        // Then
        verify { view.text = properties.text }
    }
}