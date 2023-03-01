package com.clyo.android.component.dsl

import android.view.View
import com.clyo.android.annotation.ClyoInternalAPI
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.component.ViewBinder
import com.clyo.android.properties.AbstractPropertiesData

class ComponentDeclarationDSL<T : View> @ClyoInternalAPI constructor(
    private val name: ComponentName,
    private val componentModule: ComponentModule
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        componentModule.putComponentBinder(name) { ViewBinder(block) }
    }
}
