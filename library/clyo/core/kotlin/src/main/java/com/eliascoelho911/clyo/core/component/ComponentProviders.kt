package com.eliascoelho911.clyo.core.component

typealias ComponentProviders = Set<ComponentProvider<*>>

fun componentProviders(vararg componentProvider: ComponentProvider<*>): ComponentProviders =
    componentProvider.toSet()

fun componentProviders(componentProvider: Collection<ComponentProvider<*>>): ComponentProviders =
    componentProvider.toSet()