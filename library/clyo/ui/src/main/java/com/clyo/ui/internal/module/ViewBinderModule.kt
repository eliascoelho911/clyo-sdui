package com.clyo.ui.internal.module

import android.view.View
import com.clyo.data.ViewName
import com.clyo.data.ViewProperties
import com.clyo.ui.ViewBinder
import com.clyo.ui.dsl.viewBinder

/**
 * Essa classe é responsável por armazenar e prover [ViewBinder] da [View] com a key [ViewName]
 */
class ViewBinderModule : Module<ViewName, ViewBinder<*>>() {
    fun <T : View> binder(viewName: ViewName, block: T.(properties: ViewProperties) -> Unit) {
        val binder: InstanceFactory<ViewBinder<*>> = {
            viewBinder(block)
        }
        declare(viewName, binder)
    }
}
