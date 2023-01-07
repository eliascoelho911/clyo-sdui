package com.clyo.android.widgets.material3

import com.clyo.android.module.dsl.clyoModule
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

val ClyoMaterial3Module = clyoModule {
    component<MaterialButton>("button") {
        binder { properties ->
            text = properties.getStringOrNull("text").orEmpty()
        }
    }
    component<MaterialTextView>("text") {
        binder { properties ->
            text = properties.getStringOrNull("text").orEmpty()
        }
    }
}