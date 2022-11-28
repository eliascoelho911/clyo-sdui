package com.clyo.android.material3.components

import com.clyo.core.component.componentModule
import com.clyo.core.component.modifications.updateSize
import com.clyo.core.component.provider.component
import com.google.android.material.button.MaterialButton

val ClyoMaterial3 = componentModule {
    component("button") { context, data ->
        MaterialButton(context).apply {
            updateSize(data.properties)
            text = data.properties.getStringOrNull("text")
        }
    }
}
