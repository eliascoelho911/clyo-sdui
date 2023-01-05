package com.clyo.android.component

import android.view.View
import com.clyo.data.PropertiesData

internal data class Component<T : View>(
    val view: T,
    val componentBinder: ComponentBinder<T>
) {
    fun bind(properties: PropertiesData): T {
        componentBinder.assign(properties, view)
        return view
    }
}