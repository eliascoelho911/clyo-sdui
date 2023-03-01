package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class WidgetBinderTest {

    @Test
    fun `test assign`() {
        // Given
        val view = mockk<View>(relaxed = true)
        val propertiesData = mockk<AbstractPropertiesData>()
        val binderBlock = mockk<(View, properties: AbstractPropertiesData) -> Unit>(relaxed = true)
        val viewBinder = ViewBinder(binderBlock)

        // When
        viewBinder.assign(propertiesData, view)

        // Then
        verify { binderBlock(view, propertiesData) }
    }
}