package com.clyo.android.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.common.newInstance
import com.clyo.data.widget.getProperties
import com.clyo.stubs.ClyoStub
import com.clyo.stubs.WidgetStub
import com.clyo.widget.TextProperties
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Test

internal class TextWidgetTest {
    private val view: AppCompatTextView = mockk(relaxed = true)
    private val viewKClass = AppCompatTextView::class

    @Test
    fun `should assign text properties to text view`() {
        // Given
        val widgetId = WidgetStub.Text.id
        val properties = ClyoStub.clyo.properties
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
        val properties = ClyoStub.clyo.properties
        val context = mockk<Context>(relaxed = true)
        val binder = TextBinder(widgetJson.id)
        val widget = Widget(viewKClass, binder)

        mockkStatic("com.clyo.android.common.KClassExtensionsKt")
        every { viewKClass.newInstance(context) } returns view

        // When

        widget.render(context, properties)

        // Then
        verify { view.text = properties.getProperties<TextProperties>(widgetJson.id).text }
    }
}