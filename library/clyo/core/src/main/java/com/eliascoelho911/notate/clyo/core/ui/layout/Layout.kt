package com.eliascoelho911.notate.clyo.core.ui.layout

import com.eliascoelho911.notate.clyo.core.ui.component.Component

abstract class Layout {
    private val components = ArrayDeque<Component>()

    fun add(component: Component) {
        components
    }
}