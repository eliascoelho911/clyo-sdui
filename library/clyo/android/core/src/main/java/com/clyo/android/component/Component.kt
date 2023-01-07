package com.clyo.android.component

import android.view.View
import com.clyo.data.PropertiesData

internal data class Component<T : View>(
    val view: T,
    val binder: ViewBinder<T>
) {
    fun bind(properties: PropertiesData): T {
        binder.assign(properties, view)
        return view
    }
}