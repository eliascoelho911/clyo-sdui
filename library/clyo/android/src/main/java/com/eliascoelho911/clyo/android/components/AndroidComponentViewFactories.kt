package com.eliascoelho911.clyo.android.components

import com.clyo.core.android.ComponentViewFactory
import kotlin.reflect.KClass

// TODO Gerar uma classe automatica
val AndroidComponentViewFactories: Set<KClass<out ComponentViewFactory<*>>> = setOf(ButtonComponentViewFactory::class)