package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.ComponentBinder
import com.clyo.android.properties.AbstractPropertiesData

class WidgetBinder<T : View>(
    override val binderBlock: T.(properties: AbstractPropertiesData) -> Unit
) : ComponentBinder<T>()