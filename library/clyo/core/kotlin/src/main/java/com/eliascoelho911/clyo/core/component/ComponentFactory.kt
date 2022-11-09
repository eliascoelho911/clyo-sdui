package com.eliascoelho911.clyo.core.component

import com.eliascoelho911.clyo.core.data.component.ComponentData

interface ComponentFactory<COMPONENT: Component> {
    fun create(data: ComponentData): COMPONENT
}