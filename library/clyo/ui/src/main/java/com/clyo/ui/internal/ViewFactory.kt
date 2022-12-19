package com.clyo.ui.internal

import android.content.Context
import android.view.View
import com.clyo.data.ViewData
import com.clyo.data.ViewProperties
import kotlin.reflect.KClass

/**
 * Terá a responsabilidade de criar uma instância de [View] baseado no [ViewData]
 */
internal class ViewFactory(
    private val viewClassProvider: ViewClassProvider,
    private val viewBinderManager: ViewBinderManager
) {

    /**
     * @return [View] com todos as propriedades já atribuidas
     */
    fun create(data: ViewData, context: Context): View = createAndBindView(data, context)

    private fun createAndBindView(data: ViewData, context: Context): View {
        val viewKlass: KClass<out View> = viewClassProvider.provide(data.name)
        return createAndBindView(data.properties, viewKlass, context)
    }

    private fun createAndBindView(
        properties: ViewProperties,
        viewClass: KClass<out View>,
        context: Context
    ): View {
        return createViewInstance(viewClass, context).bind(properties)
    }

    private fun createViewInstance(viewClass: KClass<out View>, context: Context): View {
        // TODO Melhorar tratamento de erro
        return runCatching {
            val constructor = viewClass.constructors.first()
            constructor.call(context)
        }.getOrElse { error(it) }
    }

    private fun View.bind(properties: ViewProperties) = apply {
        viewBinderManager.bind(this, properties)
    }
}