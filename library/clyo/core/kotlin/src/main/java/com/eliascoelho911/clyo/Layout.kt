package com.eliascoelho911.clyo

import com.eliascoelho911.clyo.component.Component

abstract class Layout {
    private val components = ArrayDeque<Component>()

    fun add(component: Component) {
        components
    }
}