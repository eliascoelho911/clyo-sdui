package com.clyo.android.layout

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.common.newInstance
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Test

internal class LayoutBuilderTest {

    @Test
    fun `should build layout`() {
        // Given
        val layoutBuilder = LayoutBuilder<ViewGroup>()
        val viewKClass = ViewGroup::class
        val viewGroup = mockk<ViewGroup>(relaxed = true)
        val context = mockk<Context>(relaxed = true)
        val expectedLayout = Layout(viewGroup)

        // When
        mockkStatic("com.clyo.android.common.KClassExtensionsKt")
        every { viewKClass.newInstance(context) } returns viewGroup

        val result = layoutBuilder.layout(context, viewKClass).build()

        // Then
        assertEquals(result, expectedLayout)
    }
}