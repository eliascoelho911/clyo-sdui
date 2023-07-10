package com.clyo.android.ui.widget

import android.view.View
import com.clyo.android.ui.common.ViewComponent
import com.clyo.data.properties.Properties

abstract class Widget<VIEW : View, PROP : Properties> : ViewComponent<VIEW>() {
    abstract val id: String

    @Suppress("UNCHECKED_CAST")
    fun render(properties: Properties) {
        render(properties as? PROP ?: throw IllegalArgumentException("Properties type mismatch"))
    }

    abstract fun render(properties: PROP): VIEW
}