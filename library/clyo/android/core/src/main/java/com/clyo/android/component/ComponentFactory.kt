package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.ClyoDeclarations
import com.clyo.android.action.ActionInvoker
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.action.BaseActionContextData
import com.clyo.android.action.BaseActionsData
import com.clyo.android.action.OnClickActionsAssignor
import com.clyo.android.action.OnInitActionsAssignor

internal abstract class ComponentFactory {
    protected abstract val clyoDeclarations: ClyoDeclarations

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> getBinder(name: ComponentName): ComponentBinder<T> {
        return clyoDeclarations.getBinderOrNull(name).orEmpty() as ComponentBinder<T>
    }

    protected fun getActionsAssignors(actions: BaseActionsData): List<ActionsAssignor> {
        val onClickActions = actions.onClick.actionInvokers(clyoDeclarations)
        val onClickActionsAssignor = OnClickActionsAssignor(onClickActions)

        val onInitActions = actions.onInit.actionInvokers(clyoDeclarations)
        val onInitActionsAssignor = OnInitActionsAssignor(onInitActions)

        return listOf(onClickActionsAssignor, onInitActionsAssignor)
    }

    abstract fun create(context: Context, data: BaseComponentData): Component<out View>

    open fun setup(context: Context, data: BaseComponentData): Component<out View> {
        return create(context, data).also {
            it.setup(properties = data.properties)
        }
    }
}

private fun BaseActionContextData.actionInvokers(clyoDeclarations: ClyoDeclarations): List<ActionInvoker> {
    return actions.mapNotNull { actionData ->
        val action = clyoDeclarations.getActionOrNull(actionData.name)
        action?.let { ActionInvoker(action, actionData.properties) }
    }
}

private fun ComponentBinder<*>?.orEmpty(): ComponentBinder<out View> {
    return this ?: emptyBinder()
}

private fun emptyBinder(): ComponentBinder<*> = ComponentBinderImpl<View>()