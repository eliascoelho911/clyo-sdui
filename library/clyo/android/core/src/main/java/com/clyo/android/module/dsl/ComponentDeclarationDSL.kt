package com.clyo.android.module.dsl

import android.view.View
import com.clyo.android.annotation.ClyoInternalAPI
import com.clyo.android.component.ComponentName
import com.clyo.android.component.GenericViewBinder
import com.clyo.android.module.Module
import com.clyo.android.properties.AbstractPropertiesData

class ComponentDeclarationDSL<T : View> @ClyoInternalAPI constructor(
    private val name: ComponentName,
    private val module: Module
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        module.declare(name) { GenericViewBinder(block) }
    }
}
