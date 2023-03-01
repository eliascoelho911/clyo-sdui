package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.util.createViewInstance

//Todo [Melhoria] Criar uma abstração para compartilhar comportamento com [ContainerFactory]
internal interface ComponentFactory {
    fun create(name: ComponentName): Component<out View>
}

internal class ComponentFactoryImpl(
    private val context: Context,
    private val componentModule: ComponentModule
) : ComponentFactory {

    // Erro quando modulo possui um view class registrado mas não tem view binder para o name
    override fun create(name: ComponentName): Component<out View> {
        val viewClass = componentModule.getComponentKClassOrNull(name)
        return create(name, viewClass.createViewInstance(context))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> create(name: ComponentName, view: T): Component<T> {
        val viewBinder = componentModule.getComponentBinder(name) as ComponentBinder<T>
        return Component(view, viewBinder)
    }
}