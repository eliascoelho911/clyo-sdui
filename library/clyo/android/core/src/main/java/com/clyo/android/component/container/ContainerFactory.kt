package com.clyo.android.component.container

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.ClyoDeclarations
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.ComponentFactory
import com.clyo.android.util.createViewInstance

internal class ContainerFactory(
    override val clyoDeclarations: ClyoDeclarations
) : ComponentFactory() {
    override fun create(context: Context, data: BaseComponentData): Container<*> {
        val viewKClass = clyoDeclarations.getViewKClassOrNull(data.name)
            ?: error("Container $data.name has not been declared")

        return create(
            data = data,
            viewGroup = viewKClass.createViewInstance(context) as ViewGroup
        )
    }

    override fun setup(context: Context, data: BaseComponentData): Container<*> {
        return super.setup(context, data) as Container<*>
    }

    private fun <T : ViewGroup> create(data: BaseComponentData, viewGroup: T): Container<T> {
        return Container(
            view = viewGroup,
            binder = getBinder(data.name),
            actionsAssignor = getActionsAssignor(data.onClickActions)
        )
    }
}