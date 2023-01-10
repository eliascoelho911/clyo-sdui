package com.clyo.android.component

import android.view.View
import com.clyo.data.PropertiesData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class ComponentTest {
    private val view = mockk<View>(relaxed = true)

    private val viewBinder = mockk<ViewBinder<View>>(relaxed = true)

    private val component = Component(view, viewBinder)

    @Test
    fun `bind properties to view`() {
        // Given
        val propertiesData = mockk<PropertiesData>()

        // When
        component.bind(propertiesData)

        // Then
        verify { viewBinder.assign(propertiesData, view) }
    }
}
