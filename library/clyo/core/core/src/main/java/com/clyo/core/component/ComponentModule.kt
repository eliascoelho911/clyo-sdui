package com.clyo.core.component

import android.content.Context
import com.clyo.core.component.provider.ComponentProvider
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName

class ComponentModule(initialModule: Map<ComponentName, ComponentProvider<*, *>> = emptyMap()) {
    private val module = HashMap(initialModule)

    fun add(name: ComponentName, provider: ComponentProvider<*, *>) {
        module[name] = provider
    }

    operator fun plus(other: ComponentModule): ComponentModule =
        ComponentModule(module + other.module)

    @Suppress("UNCHECKED_CAST")
    fun <DATA : ComponentData, COMPONENT : Component> get(
        context: Context,
        data: DATA
    ): COMPONENT {
        val provider = module[data.name] ?: TODO("ERRO PROVIDER NÃO ENCONTRADO")
        provider as ComponentProvider<DATA, COMPONENT>
        return provider.provide(context, data)
    }

    fun remove(name: ComponentName) {
        module.remove(name)
    }

    internal fun clear() {
        module.clear()
    }
}

fun componentModule(
    module: ComponentModule.() -> Unit
) = ComponentModule().apply(module)