package com.clyo.android.ui

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.ComponentFactory
import com.clyo.android.ui.component.ContainerFactory
import com.clyo.android.ui.component.WidgetFactory
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.WidgetJson
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.serialization.json.Json
import org.junit.Test

internal class ClyoEngineTest {
    private val json = mockk<Json>(relaxed = true)
    private val widgetFactory = mockk<WidgetFactory>(relaxed = true)
    private val componentFactory = mockk<ContainerFactory>(relaxed = true)
    private val clyoEngine = ClyoEngine(json, widgetFactory, componentFactory)

    @Test
    fun `should render all children`() {
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
        clyoEngine.render(container, propertiesJson)

        // Then
        container.children.forEach { widget ->
            verify { widget.render(properties) }
        }
    }

    @Test
    fun `should create container`() {
        // Given
        val context = mockk<Context>(relaxed = true)
        val widgetJson = mockk<WidgetJson>(relaxed = true) {
            every { type } returns "widget"
        }
        val widget = mockk<Widget<*, *>>(relaxed = true)
        val containerJson = mockk<ContainerJson>(relaxed = true) {
            every { type } returns "container"
            every { content } returns listOf(widgetJson)
        }
        val container = mockk<Container<ViewGroup>>(relaxed = true)
        every { componentFactory.create(context, "container") } returns container
        every { widgetFactory.create(context, "widget") } returns widget

        // When
        clyoEngine.create(context, containerJson)

        // Then
        verify(exactly = 1) { container.add(widget) }
    }
}