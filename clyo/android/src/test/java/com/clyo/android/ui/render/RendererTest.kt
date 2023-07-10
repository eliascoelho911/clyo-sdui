package com.clyo.android.ui.render

import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.component.container.Container
import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.serialization.json.Json
import org.junit.Test

internal class RendererTest {
    private val json = mockk<Json>(relaxed = true)
    private val renderer = Renderer(json)

    @Test
    fun `render should render all children`() {
        // Given
        val container = mockk<Container<ViewGroup>>(relaxed = true) {
            every { children } returns listOf(
                mockk(relaxed = true),
            )
        }
        mockkStatic("com.clyo.android.common.properties.PropertiesJsonExtKt")
        val properties = mockk<Properties>(relaxed = true)
        val propertiesJson = mockk<PropertiesJson>(relaxed = true) {
            every { decodeProperties(json, any()) } returns properties
        }

        // When
        renderer.render(container, propertiesJson)

        // Then
        container.children.forEach { widget ->
            verify { widget.render(properties) }
        }
    }
}