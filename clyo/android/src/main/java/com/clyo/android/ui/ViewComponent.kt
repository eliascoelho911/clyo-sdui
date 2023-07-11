package com.clyo.android.ui

import android.content.Context
import android.view.View

abstract class ViewComponent<VIEW : View> internal constructor() {
    private var viewInstance: VIEW? = null

    fun getView(): VIEW {
        return viewInstance ?: throw IllegalStateException("View is not created yet")
    }

    fun getOrCreateView(context: Context): VIEW {
        return viewInstance ?: run {
            createView(context)
            getView()
        }
    }

    fun createView(context: Context) {
        viewInstance = newViewInstance(context)
    }

    fun destroyView() {
        viewInstance = null
    }

    fun applyOnView(block: VIEW.() -> Unit): VIEW {
        return getView().apply(block)
    }

    protected abstract fun newViewInstance(context: Context): VIEW
}