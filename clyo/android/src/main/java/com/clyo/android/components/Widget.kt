package com.clyo.android.components

import android.view.View
import com.clyo.component.properties.WidgetProperties

abstract class Widget<V : View, P : WidgetProperties> : Component<V> {
    abstract fun bind(properties: P)
}