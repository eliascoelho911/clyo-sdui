package com.eliascoelho911.clyo.data

typealias ComponentName = String

typealias ComponentProperties = Map<String, PropertyValue>

interface ComponentData {
    val name: ComponentName
    val properties: ComponentProperties
}