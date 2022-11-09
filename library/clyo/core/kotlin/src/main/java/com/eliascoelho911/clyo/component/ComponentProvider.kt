package com.eliascoelho911.clyo.component

import com.eliascoelho911.clyo.data.ComponentData

interface ComponentProvider<COMPONENT : Component> {
    fun provide(data: ComponentData): COMPONENT
}