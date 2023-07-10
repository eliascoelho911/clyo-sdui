package com.clyo.android.ui.component.container

import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.impl.layout.BoxContainer
import com.clyo.android.impl.widget.Text
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

class ContainerTest {
    @Test
    fun `should add widget to view group`() {
        // Given
        val frameLayout = mockk<FrameLayout>(relaxed = true)
        val layout = spyk(BoxContainer()) {
            every { getView() } returns frameLayout
        }
        val textView = mockk<AppCompatTextView>(relaxed = true)
        val textWidget = spyk(Text()) {
            every { getView() } returns textView
        }

        // When
        layout.add(textWidget)

        // Then
        verify { frameLayout.addView(textView) }
    }

    @Test
    fun `should add all widgets to view group`() {
        // Given
        val frameLayout = mockk<FrameLayout>(relaxed = true)
        val layout = spyk(BoxContainer()) {
            every { getView() } returns frameLayout
        }
        val textView = mockk<AppCompatTextView>(relaxed = true)
        val textWidget = spyk(Text()) {
            every { getView() } returns textView
        }
        val widgets = listOf(textWidget, textWidget, textWidget)

        // When
        layout.addAll(widgets)

        // Then
        verify(exactly = 3) { layout.add(any()) }
    }
}