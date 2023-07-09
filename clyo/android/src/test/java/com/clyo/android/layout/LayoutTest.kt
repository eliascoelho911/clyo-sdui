package com.clyo.android.layout

import android.view.ViewGroup
import com.clyo.android.widget.Widget
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class LayoutTest {
    private val viewGroup = mockk<ViewGroup>(relaxed = true)

    @Test
    fun `should add widget to view group`() {
        // Given
        val layout = Layout(viewGroup)
        val widget = mockk<Widget<*, *>>(relaxed = true)

        // When
        layout.add(widget)

        // Then
        verify { viewGroup.addView(widget.view) }
    }

    @Test
    fun `should add all widgets to view group`() {
        // Given
        val layout = Layout(viewGroup)
        val widgets = listOf(
            mockk<Widget<*, *>>(relaxed = true),
            mockk<Widget<*, *>>(relaxed = true),
            mockk<Widget<*, *>>(relaxed = true)
        )

        // When
        layout.add(widgets)

        // Then
        verify { viewGroup.addView(widgets[0].view) }
        verify { viewGroup.addView(widgets[1].view) }
        verify { viewGroup.addView(widgets[2].view) }
    }
}