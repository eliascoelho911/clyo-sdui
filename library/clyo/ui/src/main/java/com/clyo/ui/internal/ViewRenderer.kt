package com.clyo.ui.internal

import android.content.Context
import android.view.View
import com.clyo.data.ViewData

/**
 * Terá a responsabilidade de criar e renderizar uma [View] com os dados do [ViewData]
 */
internal class ViewRenderer(
    private val viewClassInstantiator: ViewClassInstantiator,
    private val viewBinderInteractor: ViewBinderInteractor
) {

    /**
     * @return [View] com todos as propriedades já atribuidas
     */
    fun render(context: Context, data: ViewData): View {
        return viewClassInstantiator.newInstance(context, viewName = data.name).also {
            it.bind(data)
        }
    }

    private fun View.bind(data: ViewData) {
        viewBinderInteractor.bind(this, name = data.name, properties = data.properties)
    }
}