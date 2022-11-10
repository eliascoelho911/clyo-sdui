package com.eliascoelho911.clyo.component

import com.eliascoelho911.clyo.data.ComponentDataContract

interface ComponentProvider<COMPONENT : Component> {
    fun provide(data: ComponentDataContract): COMPONENT
}