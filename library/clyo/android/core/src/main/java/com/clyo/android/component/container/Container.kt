package com.clyo.android.component.container

import android.view.ViewGroup
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.widget.Widget
import com.clyo.android.properties.BasePropertiesData

internal class Container<T : ViewGroup>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>() {

    private val clyoContainer = view as ClyoContainer

    fun addWidget(widget: Widget<*>, layoutProperties: BasePropertiesData) {
        clyoContainer.addWidget(widget.view, layoutProperties)
    }
}