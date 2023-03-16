package com.clyo.android.component

import android.view.View
import com.clyo.android.component.properties.BasePropertiesData
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
        val propertiesData = mockk<BasePropertiesData>()

        // When
        component.bind(propertiesData)

        // Then
        verify { componentBinder.bind(propertiesData, view) }
    }
}
