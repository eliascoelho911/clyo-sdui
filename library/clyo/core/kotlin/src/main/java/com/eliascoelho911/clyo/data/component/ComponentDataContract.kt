package com.eliascoelho911.clyo.data.component

import com.eliascoelho911.clyo.data.PropertyValue

typealias ComponentName = String

interface ComponentDataContract {
    val name: ComponentName
    val properties: Map<String, PropertyValue>
}