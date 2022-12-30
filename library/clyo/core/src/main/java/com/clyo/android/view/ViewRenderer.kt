package com.clyo.android.view

import android.content.Context
import android.view.View
import com.clyo.data.ViewData

/**
 * Terá a responsabilidade de criar e renderizar uma [View] com os dados do [ViewData]
 */
internal class ViewRenderer(
    private val viewInstantiator: ViewInstantiator,
    private val viewBinderInteractor: ViewBinderInteractor
) {

    /**
     * @return [View] com todos as propriedades já atribuidas
     */
    fun render(context: Context, data: ViewData): View {
        return viewInstantiator.newInstance(context, viewName = data.name).also {
            it.bind(data)
        }
    }

    private fun View.bind(data: ViewData) {
        viewBinderInteractor.bind(this, name = data.name, properties = data.properties)
    }
}