package com.clyo.android.view

import android.content.Context
import android.view.View
import com.clyo.core.data.WidgetData

/**
 * Terá a responsabilidade de criar e renderizar uma [View] com os dados do [WidgetData]
 */
internal class ViewRenderer(
    private val viewInstantiator: ViewInstantiator,
    private val viewBinderInteractor: ViewBinderInteractor
) {

    /**
     * @return [View] com todos as propriedades já atribuidas
     */
    fun render(context: Context, data: WidgetData): View {
        return viewInstantiator.newInstance(context, widgetName = data.name).also {
            it.bind(data)
        }
    }

    private fun View.bind(data: WidgetData) {
        viewBinderInteractor.bind(this, name = data.name, properties = data.properties)
    }
}