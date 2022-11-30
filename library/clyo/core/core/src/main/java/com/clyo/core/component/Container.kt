package com.clyo.core.component

import android.view.ViewGroup
import com.clyo.core.data.ComponentProperties

class Container<T : ViewGroup>(
    viewGroup: T,
    properties: ComponentProperties,
    content: List<Component<*>>
) : Component<T>(viewGroup, properties) {
    init {
        submitContent(content)
    }

    private fun submitContent(content: List<Component<*>>) {
        content.forEach { component ->
            bind {
                addView(component.view)
            }
        }
    }
}