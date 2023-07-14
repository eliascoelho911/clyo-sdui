package com.clyo.android.ui

import android.content.Context
import android.view.View

abstract class ViewComponent<VIEW : View> internal constructor() {
    private var viewInstance: VIEW? = null

    fun createView(context: Context) {
        viewInstance = viewInstance(context)
    }

    fun getView(): VIEW {
        return viewInstance ?: throw IllegalStateException("View is not created yet")
    }

    fun destroy() {
        viewInstance = null
    }

    protected abstract fun viewInstance(context: Context): VIEW
}

fun <VIEW : View> ViewComponent<VIEW>.applyOnView(
    block: VIEW.() -> Unit
): VIEW {
    return getView().apply(block)
}