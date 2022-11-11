package com.eliascoelho911.clyo.data.component

interface ComponentDataCreator<COMPONENT : ComponentData> {
    fun create(data: ComponentDataContract): COMPONENT
}

typealias ComponentDataCreators = Set<ComponentDataCreator<*>>

fun componentDataCreators(vararg componentDataCreator: ComponentDataCreator<*>): ComponentDataCreators =
    componentDataCreator.toSet()

fun componentDataCreators(componentDataCreator: Collection<ComponentDataCreator<*>>): ComponentDataCreators =
    componentDataCreator.toSet()