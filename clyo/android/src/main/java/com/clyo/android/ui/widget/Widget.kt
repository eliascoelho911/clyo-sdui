package com.clyo.android.ui.widget

import android.view.View
import com.clyo.android.ui.ViewComponent
import com.clyo.data.properties.Properties

abstract class Widget<VIEW : View, PROP : Properties> : ViewComponent<VIEW>() {
    abstract fun render(properties: PROP): VIEW
}