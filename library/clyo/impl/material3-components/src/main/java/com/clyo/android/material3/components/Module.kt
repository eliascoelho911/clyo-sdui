package com.clyo.android.material3.components

import com.clyo.core.component.component
import com.clyo.core.component.componentModule
import com.clyo.core.component.modifications.updateSizeByProperties
import com.google.android.material.button.MaterialButton

val ClyoMaterial3 = componentModule {
    component<MaterialButton>("button") {
        view { MaterialButton(it) }
        bind { properties ->
            updateSizeByProperties(properties)
            text = properties.getStringOrNull("text")
        }
    }
}
