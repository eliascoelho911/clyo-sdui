package com.clyo.android.container

import android.view.ViewGroup
import com.clyo.data.PropertiesData

internal data class Container<T : ViewGroup>(
    val viewGroup: T,
    private val binder: ContainerBinder<T>
) {
    fun bind(properties: PropertiesData): T {
        binder.assign(properties, viewGroup)
        return viewGroup
    }
}