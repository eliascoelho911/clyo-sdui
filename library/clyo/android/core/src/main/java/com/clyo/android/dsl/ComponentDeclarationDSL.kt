package com.clyo.android.dsl

import android.view.View
import com.clyo.android.component.ComponentBinderImpl
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.properties.AbstractPropertiesData

class ComponentDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val componentModule: ComponentModule
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        componentModule.putBinder(name) { ComponentBinderImpl(block) }
    }
}