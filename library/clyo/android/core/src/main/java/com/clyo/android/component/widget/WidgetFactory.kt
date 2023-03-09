package com.clyo.android.component.widget

import android.content.Context
import android.view.View
import com.clyo.android.ClyoDeclarations
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.ComponentFactory
import com.clyo.android.util.createViewInstance

internal class WidgetFactory(
    override val clyoDeclarations: ClyoDeclarations
) : ComponentFactory() {
    override fun create(context: Context, data: BaseComponentData): Widget<*> {
        val viewKClass = clyoDeclarations.getViewKClassOrNull(data.name)
            ?: error("Widget $data.name has not been declared")

        return create(
            view = viewKClass.createViewInstance(context),
            data = data,
        )
    }

    override fun setup(
        context: Context,
        data: BaseComponentData
    ): Widget<*> {
        return super.setup(context, data) as Widget<*>
    }

    private fun <T : View> create(view: T, data: BaseComponentData): Widget<T> {
        return Widget(
            view = view,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}