package com.clyo.android.view.renderer

import android.content.Context
import android.view.View
import com.clyo.core.ClyoRenderer
import com.clyo.core.data.WidgetData

/**
 * Terá a responsabilidade de criar e renderizar uma [View] com os dados do [WidgetData]
 */
internal class ViewRenderer(
    private val context: Context,
    private val viewInstantiator: ViewInstantiator,
    private val viewBinderInteractor: ViewBinderInteractor
): ClyoRenderer<View>() {

    override fun render(data: WidgetData): View {
        return viewInstantiator.newInstance(context, clyoId = data.id).also {
            it.bind(data)
        }
    }

    private fun View.bind(data: WidgetData) {
        viewBinderInteractor.bind(this, name = data.id, properties = data.properties)
    }
}