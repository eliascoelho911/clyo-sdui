package com.clyo.component

import com.clyo.component.properties.WidgetProperties

interface Widget<V : Any, P : WidgetProperties> : Component<V> {
    fun bind(properties: P)
}