package com.eliascoelho911.clyo.core

import com.eliascoelho911.clyo.core.component.ComponentFactory
import com.eliascoelho911.clyo.core.module.ComponentFactoryModule

object Clyo {
    val componentFactoryModule = ComponentFactoryModule()
}

fun findComponentFactory(key: String): ComponentFactory<*>? =
    Clyo.componentFactoryModule.findByKey(key)