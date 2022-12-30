package com.clyo.android.material3.components

import com.clyo.android.view.viewBinders
import com.google.android.material.button.MaterialButton

val ClyoMaterial3 = viewBinders {
    binder<MaterialButton>("button") { properties ->
        text = properties.getStringOrNull("text")
    }
}
