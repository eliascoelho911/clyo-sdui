package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ComponentRenderer
import com.clyo.data.properties.Properties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class WidgetTest {
    private val view = mockk<View>(relaxed = true)
    private val id = "id"
    private val renderer = mockk<ComponentRenderer<View, Properties>>(relaxed = true)
    private val widget = Widget(view, id, renderer)

    @Test
    fun `should render widget`() {
        // Given
        val properties = mockk<Properties>(relaxed = true)

        // When
        widget.render(properties)

        // Then
        verify { renderer.render(view, properties) }
    }
}