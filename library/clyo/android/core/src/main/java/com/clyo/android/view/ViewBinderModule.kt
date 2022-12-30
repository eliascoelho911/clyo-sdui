package com.clyo.android.view

import android.view.View
import com.clyo.core.data.ViewName
import com.clyo.core.data.ViewProperties
import com.clyo.core.util.InstanceFactory
import com.clyo.core.util.Module

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
