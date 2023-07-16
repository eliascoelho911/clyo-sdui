package com.clyo.android.ui

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.impl.container.BoxContainer
import com.clyo.stubs.Text
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class ContainerTest {
    private val context = mockk<Context>(relaxed = true)

    private val textView = mockk<AppCompatTextView>(relaxed = true)
    private val textWidget = Text(context, "txt", textView)

    private val containerViewGroup = mockk<FrameLayout>(relaxed = true)
    private val container =
        BoxContainer(context, listOf(textWidget, textWidget), containerViewGroup)

    @Test
    fun `show - should add all widgets to view group`() {
        // Given
        val viewGroup = mockk<ViewGroup>(relaxed = true)

        // When
        container.showIn(viewGroup)

        // Then
        verify(exactly = 2) { containerViewGroup.addView(textView) }
    }
}