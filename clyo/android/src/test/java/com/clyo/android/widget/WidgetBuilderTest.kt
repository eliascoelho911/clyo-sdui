package com.clyo.android.widget

import android.content.Context
import android.view.View
import com.clyo.android.common.newInstance
import com.clyo.data.properties.Properties
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Test

internal class WidgetBuilderTest {
    @Test
    fun `should build widget`() {
        // Given
        val widgetBuilder = WidgetBuilder<View, Properties>()
        val viewKClass = View::class
        val view = mockk<View>(relaxed = true)
        val binder = mockk<WidgetBinder<View, Properties>>(relaxed = true)
        val context = mockk<Context>(relaxed = true)
        val expectedWidget = Widget(view, binder)

        // When
        mockkStatic("com.clyo.android.common.KClassExtensionsKt")
        every { viewKClass.newInstance(context) } returns view

        val result = widgetBuilder.view(context, viewKClass).binder(binder).build()

        // Then
        assertEquals(result, expectedWidget)
    }
}