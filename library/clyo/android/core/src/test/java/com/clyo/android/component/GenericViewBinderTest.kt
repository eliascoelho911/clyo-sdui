package com.clyo.android.component

import android.view.View
import com.clyo.data.PropertiesData
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

internal class GenericViewBinderTest {

    @Test
    fun `test assign`() {
        // Given
        val view = mockk<View>(relaxed = true)
        val propertiesData = mockk<PropertiesData>()
        val binderBlock = mockk<(View, properties: PropertiesData) -> Unit>(relaxed = true)
        val viewBinder = GenericViewBinder(binderBlock)

        // When
        viewBinder.assign(propertiesData, view)

        // Then
        verify { binderBlock(view, propertiesData) }
    }
}