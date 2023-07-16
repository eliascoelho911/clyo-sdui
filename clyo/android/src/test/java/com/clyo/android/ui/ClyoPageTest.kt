package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.container.render
import com.clyo.android.ui.page.ClyoPage
import com.clyo.data.ClyoPageJson
import com.clyo.stubs.ClyoPageJsonStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.Test

internal class ClyoPageTest {
    private val container = mockk<ViewGroupContainer<*>>(relaxed = true)
    private val clyoPage = spyk(ClyoPage(), recordPrivateCalls = true)

    @Test
    fun `submit - should create container with widgets rendered`() {
        // Given
        val clyoPageJson = ClyoPageJsonStub.clyoPage
        val into = mockk<ViewGroup>(relaxed = true)

        every { clyoPage["container"](into, clyoPageJson) } returns container

        // When
        clyoPage.submit(clyoPageJson, into)

        // Then
        assertContainerCreated()
        assertContainerShown(into)
        assertWidgetsRendered(clyoPageJson)
    }

    private fun assertContainerCreated() {
        assertNotNull(clyoPage.getContainerOrNull())
        assertEquals(2, clyoPage.getContainer().content.size)
    }

    private fun assertContainerShown(into: ViewGroup) {
        verify { container.showIn(into) }
    }

    private fun assertWidgetsRendered(clyoPageJson: ClyoPageJson) {
        verify { container.render(clyoPageJson.properties) }
    }
}