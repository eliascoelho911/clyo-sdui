package com.clyo.android.dsl

import android.view.View
import com.clyo.android.ClyoDeclarations
import com.clyo.android.component.ComponentBinderImpl
import com.clyo.android.component.ComponentName
import com.clyo.android.properties.AbstractPropertiesData

class ComponentDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val clyoDeclarations: ClyoDeclarations
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        clyoDeclarations.putBinder(name) { ComponentBinderImpl(block) }
    }
}