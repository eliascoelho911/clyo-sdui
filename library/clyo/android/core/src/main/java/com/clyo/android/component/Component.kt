package com.clyo.android.component

import android.view.View
import androidx.core.view.doOnAttach
import com.clyo.android.ClyoDeclaration
import com.clyo.android.action.ActionInvoker
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.action.BaseActionData
import com.clyo.android.component.properties.BasePropertiesData

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