package com.clyo.android.component

import android.view.View
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.properties.AbstractPropertiesData

internal abstract class Component<T : View> {
    abstract val view: T

    protected abstract val binder: ComponentBinder<T>

    protected abstract val actionsAssignor: ActionsAssignor

    open fun setup(properties: AbstractPropertiesData): T {
        binder.bind(properties, view)

        actionsAssignor.assign(view)

        return view
    }
}