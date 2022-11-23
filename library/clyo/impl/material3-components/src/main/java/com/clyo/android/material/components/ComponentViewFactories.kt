package com.clyo.android.material.components

import com.clyo.core.component.ComponentFactory
import kotlin.reflect.KClass

val AndroidMaterial3ViewFactories: Set<KClass<out ComponentFactory<*>>> =
    setOf(MaterialButtonComponentViewFactory::class)