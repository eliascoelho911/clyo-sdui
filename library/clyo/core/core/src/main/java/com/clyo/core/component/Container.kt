package com.clyo.core.component

import android.view.ViewGroup
import com.clyo.core.data.ComponentProperties

class Container<T : ViewGroup>(
    viewGroup: T,
    properties: ComponentProperties
) : Component<T>(viewGroup, properties) {
    fun addContent(content: List<Component<*>>) {
        content.forEach { component ->
            bind {
                addView(component.view)
            }
        }
    }
}