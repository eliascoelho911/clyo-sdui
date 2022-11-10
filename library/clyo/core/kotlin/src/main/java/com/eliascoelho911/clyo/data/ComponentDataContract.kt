package com.eliascoelho911.clyo.data

typealias ComponentName = String

interface ComponentDataContract {
    val name: ComponentName
    val properties: Map<String, PropertyValue>
}