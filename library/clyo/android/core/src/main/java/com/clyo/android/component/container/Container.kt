package com.clyo.android.component.container

import android.view.ViewGroup
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.widget.Widget
import com.clyo.android.properties.PropertiesData

internal class Container<T : ViewGroup>(
    override val view: T,
    override val binder: ComponentBinder<T>
) : Component<T>() {

    private val clyoContainerView = view as ClyoContainerView

    fun addWidget(widget: Widget<*>, layoutProperties: PropertiesData) {
        clyoContainerView.addWidget(widget.view, layoutProperties)
    }
}