package com.clyo.android.ui.page

import android.view.ViewGroup
import com.clyo.android.page.Page
import com.clyo.data.Properties
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class PageTest {
    private val container = mockk<Container<*>>(relaxed = true)
    private val page = Page(container)

    @Test
    fun `should attach container to parent`() {
        // given
        val parent = mockk<ViewGroup>(relaxed = true)

        // when
        page.attachTo(parent)

        // then
        verify { parent.removeAllViews() }
        verify { parent.addView(container.view) }
    }

    @Test
    fun `should render container content`() {
        // Given
        val propertiesCreator = mockk<(widgetId: String) -> Properties?>()

        // When
        page.render(propertiesCreator)

        // Then
        verify { container.renderContent(propertiesCreator) }
    }
}