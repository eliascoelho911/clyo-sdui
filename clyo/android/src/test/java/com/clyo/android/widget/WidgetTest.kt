package com.clyo.android.widget

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.impl.widget.Text
import com.clyo.android.impl.widget.TextProperties
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

internal class WidgetTest {
    @Test
    fun `should render text widget`() {
        // Given
        val properties = TextProperties("text")
        val view = mockk<AppCompatTextView>(relaxed = true)
        val textWidget = spyk(Text()) {
            every { getView() } returns view
        }

        // When
        textWidget.render(properties)

        // Then
        verify { view.text = properties.text }
    }
}