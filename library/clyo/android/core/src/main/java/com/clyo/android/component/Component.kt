package com.clyo.android.component

import android.view.View
import com.clyo.data.PropertiesData

internal class Component<T : View>(
    val view: T,
    private val binder: ViewBinder<T>
) {
    fun bind(properties: PropertiesData): T {
        binder.assign(properties, view)
        return view
    }
}