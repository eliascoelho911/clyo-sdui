package com.clyo.core.component

import android.content.Context
import android.view.View
import com.clyo.core.data.ComponentProperties

class ComponentBuilder<VIEW : View> internal constructor() {
    private lateinit var view: (context: Context) -> VIEW
    private var bind: VIEW.(properties: ComponentProperties) -> Unit = {}

    fun view(view: (context: Context) -> VIEW) = apply {
        this.view = view
    }

    fun bind(bind: VIEW.(properties: ComponentProperties) -> Unit) = apply {
        this.bind = bind
    }

    fun build(context: Context, properties: ComponentProperties) =
        Component(view(context), properties).apply { bind(bind) }
}