package com.clyo.android.dsl

import android.view.View
import com.clyo.android.ClyoDeclarations
import com.clyo.android.component.ComponentBinderImpl
import com.clyo.android.component.ComponentName
import com.clyo.android.properties.BasePropertiesData

class ComponentDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val clyoDeclarations: ClyoDeclarations
) {
    fun binder(block: T.(properties: BasePropertiesData) -> Unit) {
        clyoDeclarations.putBinder(name) { ComponentBinderImpl(block) }
    }
}