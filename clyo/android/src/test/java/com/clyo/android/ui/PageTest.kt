package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.container.render
import com.clyo.android.ui.page.Page
import com.clyo.data.PageJson
import com.clyo.stubs.ClyoPageJsonStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.Test

internal class PageTest {
    private val container = mockk<Container<*>>(relaxed = true)
    private val page = spyk(Page(), recordPrivateCalls = true)

    @Test
    fun `submit - should create container with widgets rendered`() {
        // Given
        val clyoPageJson = ClyoPageJsonStub.clyoPage
        val into = mockk<ViewGroup>(relaxed = true)

        every { page["container"](into, clyoPageJson) } returns container

        // When
        page.render(clyoPageJson, into)

        // Then
        assertContainerCreated()
        assertContainerShown(into)
        assertWidgetsRendered(clyoPageJson)
    }

    private fun assertContainerCreated() {
        assertNotNull(page.getContainerOrNull())
        assertEquals(2, page.getContainer().content.size)
    }

    private fun assertContainerShown(into: ViewGroup) {
        verify { container.showIn(into) }
    }

    private fun assertWidgetsRendered(pageJson: PageJson) {
        verify { container.render(pageJson.properties) }
    }
}