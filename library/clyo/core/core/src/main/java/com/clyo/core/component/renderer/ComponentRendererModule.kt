package com.clyo.core.component.renderer

import android.content.Context
import com.clyo.core.component.Component
import com.clyo.core.component.Container
import com.clyo.core.component.Widget
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ContainerData
import com.clyo.core.data.WidgetData
import java.io.Closeable
import kotlin.reflect.KClass

sealed class ComponentRendererModule<T : ComponentRenderer<*, *>> : Closeable {
    private val module: MutableMap<ComponentName, () -> T> =
        mutableMapOf()

    fun add(name: ComponentName, instance: () -> T) {
        module[name] = instance
    }

    operator fun get(name: ComponentName): T =
        module[name]?.invoke() ?: TODO("ERRO COMPONENT FACTORY NÃO ENCONTRADO")

    override fun close() {
        module.clear()
    }
}

class ContainerRendererModule : ComponentRendererModule<ContainerRenderer<*>>()

class WidgetRendererModule : ComponentRendererModule<WidgetRenderer<*>>()

fun containerRendererModule(block: ContainerRendererModule.() -> Unit) =
    ContainerRendererModule().apply(block)

inline fun <reified T : Container> ContainerRendererModule.containerRenderer(
    name: ComponentName,
    crossinline block: T.(data: ContainerData) -> Unit
) {
    val containerRenderer = object : ContainerRenderer<T>() {
        override fun createInstance(context: Context): T =
            createComponentInstance(context, T::class)

        override fun bind(component: T, data: ContainerData) {
            super.bind(component, data)
            component.block(data)
        }
    }

    add(name) { containerRenderer }
}

fun widgetRendererModule(block: WidgetRendererModule.() -> Unit) =
    WidgetRendererModule().apply(block)

inline fun <reified T : Widget> WidgetRendererModule.widgetRenderer(
    name: ComponentName,
    crossinline block: T.(data: WidgetData) -> Unit
) {
    val instance = object : WidgetRenderer<T>() {
        override fun createInstance(context: Context): T =
            createComponentInstance(context, T::class)

        override fun bind(component: T, data: WidgetData) {
            super.bind(component, data)
            component.block(data)
        }
    }

    add(name) { instance }
}

//TODO Melhorar essa implementação para algo mais seguro
fun <T : Component> createComponentInstance(context: Context, klass: KClass<T>): T =
    klass.constructors.firstOrNull { constructor ->
        constructor.parameters.size == 1
    }?.call(context) ?: TODO("ERRO CONSTRUTOR DEFAULT COM CONTEXTO NÃO ENCONTRADO")

