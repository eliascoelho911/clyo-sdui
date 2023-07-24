package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.widget.AndroidWidget
import com.clyo.data.Properties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class AndroidWidgetTest {
    private val view = mockk<View>(relaxed = true)
    private val id = "id"
    private val renderer = mockk<WidgetRenderer<View, Properties>>(relaxed = true)
    private val widget = AndroidWidget(view, id, renderer)

    @Test
    fun `should render widget`() {
        // Given
        val properties = mockk<Properties>(relaxed = true)

        // When
        widget.bind(properties)

        // Then
        verify { renderer.applyProperties(view, properties) }
    }
}