package com.clyo.android.ui.component.container

import android.view.ViewGroup
import com.clyo.android.component.Widget
import com.clyo.data.Properties
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class ContainerTest {
    private val viewGroup = mockk<ViewGroup>(relaxed = true)
    private val widget1 = mockk<Widget<*, *>>(relaxed = true)
    private val content = listOf(widget1)
    private val container = Container(viewGroup, content)

    @Test
    fun `should render content`() {
        // Given
        val properties = mockk<Properties>(relaxed = true)
        val propertiesCreator = mockk<(widgetId: String) -> Properties?>(relaxed = true)

        every { propertiesCreator(widget1.id) } returns properties

        // When
        container.renderContent(propertiesCreator)

        // Then
        verify { widget1.bind(properties) }
    }

    @Test
    fun `should add content to view group`() {
        verify { viewGroup.removeAllViews() }
        verify { viewGroup.addView(widget1.view) }
    }
}