package com.clyo.viewclass

import android.content.Context
import android.view.View
import com.clyo.data.ViewName
import kotlin.reflect.KClass

internal class ViewClassInstantiator(
    private val viewClassModule: ViewClassModule
) {
    fun newInstance(context: Context, viewName: ViewName): View {
        return newInstance(context, viewClassModule[viewName])
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