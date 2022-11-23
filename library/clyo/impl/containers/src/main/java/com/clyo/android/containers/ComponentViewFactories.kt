package com.clyo.android.containers

import com.clyo.core.component.ComponentFactory
import kotlin.reflect.KClass

val AndroidContainerViewFactories: Set<KClass<out ComponentFactory<*>>> =
    setOf(ColumnComponentFactory::class)