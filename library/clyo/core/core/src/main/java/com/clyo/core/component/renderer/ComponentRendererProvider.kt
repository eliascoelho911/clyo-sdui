package com.clyo.core.component.renderer

import com.clyo.core.data.ComponentName
import com.clyo.core.getScreenRenderer
import java.io.Closeable

class ComponentRendererProvider(
    private val widgetRendererModule: WidgetRendererModule = WidgetRendererModule(),
    private val containerRendererModule: ContainerRendererModule = ContainerRendererModule()
): Closeable {
    fun provideWidgetRenderer(name: ComponentName): WidgetRenderer<*> =
        widgetRendererModule[name]

    fun provideContainerRenderer(name: ComponentName): ContainerRenderer<*> =
        containerRendererModule[name]

    override fun close() {
        widgetRendererModule.close()
        containerRendererModule.close()
    }
}

fun getComponentRendererProvider(): ComponentRendererProvider =
    getScreenRenderer().componentRendererProvider

fun findWidgetRenderer(name: ComponentName): WidgetRenderer<*> =
    getComponentRendererProvider().provideWidgetRenderer(name)

fun findContainerRenderer(name: ComponentName): ContainerRenderer<*> =
    getComponentRendererProvider().provideContainerRenderer(name)
