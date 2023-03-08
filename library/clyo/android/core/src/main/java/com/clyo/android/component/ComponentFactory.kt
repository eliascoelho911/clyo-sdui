package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.action.AbstractActionData
import com.clyo.android.action.ActionInvoker
import com.clyo.android.action.ActionsAssignor

internal abstract class ComponentFactory {
    protected abstract val clyoDeclarations: ClyoDeclarations

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> getBinder(name: ComponentName): ComponentBinder<T> {
        return clyoDeclarations.getBinderOrNull(name).orEmpty() as ComponentBinder<T>
    }

    protected fun getActionsAssignor(onClickActions: List<AbstractActionData>): ActionsAssignor {
        val actions = onClickActions.mapNotNull { actionData ->
            val action = clyoDeclarations.getActionOrNull(actionData.name)
            action?.let { ActionInvoker(action, actionData.properties) }
        }
        return ActionsAssignor(actions)
    }


    abstract fun create(context: Context, data: AbstractComponentData): Component<out View>

    open fun setup(context: Context, data: AbstractComponentData): Component<out View> {
        return create(context, data).also {
            it.setup(properties = data.properties)
        }
    }
}

private fun ComponentBinder<*>?.orEmpty(): ComponentBinder<out View> {
    return this ?: emptyBinder()
}

private fun emptyBinder(): ComponentBinder<*> = ComponentBinderImpl<View>()