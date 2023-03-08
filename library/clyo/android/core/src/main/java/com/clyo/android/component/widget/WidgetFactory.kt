package com.clyo.android.component.widget

import android.content.Context
import android.view.View
import com.clyo.android.ClyoDeclarations
import com.clyo.android.action.AbstractActionData
import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.ComponentName
import com.clyo.android.util.createViewInstance

internal class WidgetFactory(
    override val clyoDeclarations: ClyoDeclarations
) : ComponentFactory() {
    override fun create(context: Context, data: AbstractComponentData): Widget<*> {
        val viewKClass = clyoDeclarations.getViewKClassOrNull(data.name)
            ?: error("Widget $data.name has not been declared")

        return create(
            view = viewKClass.createViewInstance(context),
            componentName = data.name,
            onClickActions = data.onClickActions
        )
    }

    override fun setup(
        context: Context,
        data: AbstractComponentData
    ): Widget<*> {
        return super.setup(context, data) as Widget<*>
    }

    private fun <T : View> create(
        view: T,
        componentName: ComponentName,
        onClickActions: List<AbstractActionData>
    ): Widget<T> {
        return Widget(
            view = view,
            binder = getBinder(componentName),
            actionsAssignor = getActionsAssignor(onClickActions)
        )
    }
}