package com.clyo.android.view

import android.content.Context
import android.view.View
import com.clyo.core.data.WidgetName
import kotlin.reflect.KClass

internal class ViewInstantiator(
    private val viewClassModule: ViewClassModule
) {
    fun newInstance(context: Context, widgetName: WidgetName): View {
        return newInstance(context, viewClassModule[widgetName])
    }

    // Todo Nova solução com um módulo ViewClass -> fun(): View
    private fun newInstance(context: Context, viewClass: KClass<out View>): View {
        // TODO Melhorar tratamento de erro
        return runCatching {
            val constructor = viewClass.constructors.first()
            constructor.call(context)
        }.getOrElse { error(it) }
    }
}