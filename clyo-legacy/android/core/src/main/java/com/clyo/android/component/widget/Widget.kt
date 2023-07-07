package com.clyo.android.component.widget

import android.content.Context
import android.view.View
import com.clyo.android.ClyoDeclaration
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentFactory

internal class Widget<T : View>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>()

internal class WidgetFactory(
    override val clyoDeclaration: ClyoDeclaration
) : ComponentFactory() {

    override fun justCreate(context: Context, data: BaseComponentData): Widget<*> {
        val viewProvider = clyoDeclaration.getViewProvider(data.name)

        return widget(
            view = viewProvider.provide(context),
            data = data,
        )
    }

    override fun createAndApplyProperties(
        context: Context,
        data: BaseComponentData
    ): Widget<*> {
        return super.createAndApplyProperties(context, data) as Widget<*>
    }

    private fun <T : View> widget(view: T, data: BaseComponentData): Widget<T> {
        return Widget(
            view = view,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}