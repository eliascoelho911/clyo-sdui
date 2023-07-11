package com.clyo.android.ui

import android.view.View
import com.clyo.data.properties.Properties

abstract class Widget<VIEW : View, PROP : Properties> : ViewComponent<VIEW>() {
    abstract val id: String

    @Suppress("UNCHECKED_CAST")
    fun render(properties: Properties) {
        handleProperties(
            properties as? PROP ?: throw IllegalArgumentException("Properties type mismatch")
        )
    }

    protected abstract fun handleProperties(properties: PROP): VIEW
}