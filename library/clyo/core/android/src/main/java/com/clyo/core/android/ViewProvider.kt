package com.clyo.core.android

import android.content.Context
import android.view.View
import com.clyo.core.android.annotation.DeclareComponentViewFactory
import com.eliascoelho911.clyo.ComponentData
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation

// Todo permitir que os factories tenham argumentos no construtor.
// Todo permitir adicionar custom factories
class ViewProvider(private val viewFactoryClasses: Set<KClass<out ComponentViewFactory<*>>>) {
    fun provide(
        context: Context,
        componentData: ComponentData
    ): View {
        // Todo adicionar tratativa para o envio de varios factories para o mesmo componente
        val viewFactory = viewFactoryClasses.first {
            it.findAnnotation<DeclareComponentViewFactory>()?.name == componentData.name
        }.createInstance()
        return viewFactory.create(context, componentData.properties)
    }
}