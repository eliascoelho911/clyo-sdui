package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData

internal data class Component<T : View>(
    val view: T,
    private val binder: ComponentBinder<T>
) {
    fun bind(properties: AbstractPropertiesData): T {
        binder.assign(properties, view)
        return view
    }
}