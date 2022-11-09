package com.eliascoelho911.clyo.core.component

import com.eliascoelho911.clyo.core.data.ComponentData

abstract class ComponentFactory {
    abstract fun create(data: ComponentData): Component
}