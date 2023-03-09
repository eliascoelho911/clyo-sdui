package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder

internal class Widget<T : View>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>()