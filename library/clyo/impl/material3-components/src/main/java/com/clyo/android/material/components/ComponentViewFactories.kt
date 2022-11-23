package com.clyo.android.material.components

import com.clyo.core.android.ComponentFactory
import kotlin.reflect.KClass

val AndroidMaterial3ViewFactories: Set<KClass<out ComponentFactory<*>>> =
    setOf(MaterialButtonComponentViewFactory::class)