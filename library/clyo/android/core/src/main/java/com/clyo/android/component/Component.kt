package com.clyo.android.component

import android.view.View
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.properties.BasePropertiesData

internal abstract class Component<T : View> {
    abstract val view: T

    protected abstract val binder: ComponentBinder<T>

    protected abstract val actionsAssignors: List<ActionsAssignor>

    open fun setup(properties: BasePropertiesData): T {
        binder.bind(properties, view)

        actionsAssignors.forEach {
            it.assign(view)
        }

        return view
    }
}