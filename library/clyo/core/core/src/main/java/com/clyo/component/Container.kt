package com.clyo.component

import android.view.ViewGroup
import com.clyo.data.ViewProperties

class Container<T : ViewGroup>(
    viewGroup: T,
    properties: ViewProperties
) : Component<T>(viewGroup, properties) {
    fun addContent(content: List<Component<*>>) {
        content.forEach { component ->
            bind {
                addView(component.view)
            }
        }
    }
}