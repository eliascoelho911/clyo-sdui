package com.clyo.android.dsl

import android.view.View
import com.clyo.android.ClyoDeclaration
import com.clyo.android.component.ComponentName
import com.clyo.android.component.InternalComponentBinder
import com.clyo.android.component.properties.BasePropertiesData

class ComponentDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val clyoDeclaration: ClyoDeclaration
) {
    fun binder(block: T.(properties: BasePropertiesData) -> Unit) {
        clyoDeclaration.putBinder(name) { InternalComponentBinder(block) }
    }
}