package com.clyo.android.ui

import android.view.View
import com.clyo.data.properties.Properties

interface Widget<VIEW : View, PROP : Properties> : ViewComponent<VIEW> {

    val id: String

    @Suppress("UNCHECKED_CAST")
    fun render(properties: Properties) {
        render(
            properties as? PROP ?: throw IllegalArgumentException("Properties type mismatch")
        )
    }

    fun render(properties: PROP): VIEW
}