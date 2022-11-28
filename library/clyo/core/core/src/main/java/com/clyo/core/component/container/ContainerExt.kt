package com.clyo.core.component.container

import com.clyo.core.component.Container
import com.clyo.core.data.ComponentData
import com.clyo.core.provideComponent

fun Container.addContent(content: List<ComponentData>) {
    content.forEach {
        addView(provideComponent(context, it))
    }
}