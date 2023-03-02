package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData

internal abstract class Component<T : View> {
    abstract val view: T

    protected abstract val binder: ComponentBinder<T>

    fun bind(properties: AbstractPropertiesData): T {
        binder.assign(properties, view)
        return view
    }
}