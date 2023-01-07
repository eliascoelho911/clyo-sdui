package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.module.Module
import com.clyo.data.ComponentName
import kotlin.reflect.KClass

internal interface ComponentFactory {
    fun create(name: ComponentName): Component<out View>
}

internal class ComponentFactoryImpl(
    private val context: Context,
    private val module: Module
) : ComponentFactory {

    override fun create(name: ComponentName): Component<View> {
        //Todo O comportamento de instanciar a view deve estar em outra classe, para facilitar o teste
        val viewClass = module.viewKClass(name)
        return create(name, viewInstance(context, viewClass))
    }

    private fun <T : View> create(name: ComponentName, view: T): Component<T> {
        val viewBinder = module.viewBinder<T>(name)
        return Component(view, viewBinder)
    }
}

private fun <T : View> viewInstance(context: Context, viewClass: KClass<T>): T {
    // TODO Melhorar tratamento de erro
    return runCatching {
        val constructor = viewClass.constructors.first()
        constructor.call(context)
    }.getOrElse { error(it) }
}