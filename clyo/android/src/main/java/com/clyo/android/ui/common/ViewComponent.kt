package com.clyo.android.ui.common

import android.content.Context
import android.view.View

abstract class ViewComponent<VIEW : View> internal constructor() {
    private var viewInstance: VIEW? = null

    fun getView(): VIEW {
        return viewInstance ?: throw IllegalStateException("View is not created yet")
    }

    fun getOrCreateView(context: Context): VIEW {
        return viewInstance ?: createView(context).also { view ->
            viewInstance = view
        }
    }

    fun destroyView() {
        viewInstance = null
    }

    fun applyOnView(block: VIEW.() -> Unit): VIEW {
        return getView().apply(block)
    }

    protected abstract fun createView(context: Context): VIEW
}