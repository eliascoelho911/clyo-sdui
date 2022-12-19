package com.clyo.ui.internal

import android.content.Context
import android.view.View
import com.clyo.data.ViewData
import com.clyo.data.ViewName
import com.clyo.data.ViewProperties
import com.clyo.ui.internal.module.ViewClassModule
import kotlin.reflect.KClass

/**
 * Terá a responsabilidade de criar uma instância de [View] baseado no [ViewData]
 */
internal class ViewFactory(
    private val viewClassCache: ViewClassModule,
    private val viewBinderRobot: ViewBinderRobot
) {

    /**
     * @return [View] com todos as propriedades já atribuidas
     */
    fun create(data: ViewData, context: Context): View = createAndBindView(data, context)

    private fun createAndBindView(viewData: ViewData, context: Context): View {
        val viewKlass: KClass<out View> = viewClassCache[viewData.name]
        return createAndBindView(viewData, viewKlass, context)
    }

    private fun createAndBindView(
        viewData: ViewData,
        viewClass: KClass<out View>,
        context: Context
    ): View {
        return createViewInstance(viewClass, context).bind(viewData.name, viewData.properties)
    }

    private fun createViewInstance(viewClass: KClass<out View>, context: Context): View {
        // TODO Melhorar tratamento de erro
        return runCatching {
            val constructor = viewClass.constructors.first()
            constructor.call(context)
        }.getOrElse { error(it) }
    }

    private fun View.bind(viewName: ViewName, viewProperties: ViewProperties) = apply {
        viewBinderRobot.bind(this, viewName, viewProperties)
    }
}