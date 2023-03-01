package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class ComponentTest {
    private val view = mockk<View>(relaxed = true)

    private val componentBinder = mockk<ComponentBinder<View>>(relaxed = true)

    private val component = Component(view, componentBinder)

    @Test
    fun `bind properties to view`() {
        // Given
        val propertiesData = mockk<AbstractPropertiesData>()

        // When
        component.bind(propertiesData)

        // Then
        verify { componentBinder.assign(propertiesData, view) }
    }
}
