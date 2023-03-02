package com.clyo.android.widgets.material3

import com.clyo.android.dsl.clyoModule
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

val ClyoMaterial3Module = clyoModule {
    widget<MaterialButton>("button") {
        binder { properties ->
            text = properties.getStringOrNull("text").orEmpty()
        }
    }
    widget<MaterialTextView>("text") {
        binder { properties ->
            text = properties.getStringOrNull("text").orEmpty()
        }
    }
}