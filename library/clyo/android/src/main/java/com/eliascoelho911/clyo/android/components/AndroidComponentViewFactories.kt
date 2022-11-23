package com.eliascoelho911.clyo.android.components

import com.clyo.core.android.ComponentFactory
import com.eliascoelho911.clyo.android.containers.ColumnComponentFactory
import kotlin.reflect.KClass

val AndroidComponentViewFactories: Set<KClass<out ComponentFactory<*>>> =
    setOf(ButtonComponentViewFactory::class, ColumnComponentFactory::class)