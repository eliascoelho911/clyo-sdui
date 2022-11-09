package com.eliascoelho911.clyo.core

import com.eliascoelho911.clyo.core.component.Component

abstract class Layout {
    private val components = ArrayDeque<Component>()

    fun add(component: Component) {
        components
    }
}