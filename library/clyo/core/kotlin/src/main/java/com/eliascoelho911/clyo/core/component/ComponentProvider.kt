package com.eliascoelho911.clyo.core.component

import com.eliascoelho911.clyo.core.data.ComponentData

interface ComponentProvider<COMPONENT : Component> {
    fun provide(data: ComponentData): COMPONENT
}