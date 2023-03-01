package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.module.Module
import com.clyo.android.util.createViewInstance

//Todo [Melhoria] Criar uma abstração para compartilhar comportamento com [ContainerFactory]
internal interface ComponentFactory {
    fun create(name: ComponentName): Component<out View>
}

internal class ComponentFactoryImpl(
    private val context: Context,
    private val module: Module
) : ComponentFactory {

    // Erro quando modulo possui um view class registrado mas não tem view binder para o name
    override fun create(name: ComponentName): Component<out View> {
        val viewClass = module.viewKClass(name)
        return create(name, viewClass.createViewInstance(context))
    }

    private fun <T : View> create(name: ComponentName, view: T): Component<T> {
        val viewBinder = module.viewBinder<T>(name)
        return Component(view, viewBinder)
    }
}