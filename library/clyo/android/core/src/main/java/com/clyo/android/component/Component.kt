package com.clyo.android.component

import android.content.Context
import android.view.View
import androidx.core.view.doOnAttach
import com.clyo.android.ClyoDeclarations
import com.clyo.android.action.ActionInvoker
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.action.BaseActionContextData
import com.clyo.android.action.BaseActionsData
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

abstract class ComponentBinder<T : View> {
    protected abstract val binderBlock: T.(properties: BasePropertiesData) -> Unit

    fun bind(properties: BasePropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}

internal class ComponentBinderImpl<T : View>(
    override val binderBlock: T.(properties: BasePropertiesData) -> Unit = {}
) : ComponentBinder<T>()

internal fun ComponentBinder<*>?.orEmpty(): ComponentBinder<out View> {
    return this ?: emptyBinder()
}

internal fun emptyBinder(): ComponentBinder<*> = ComponentBinderImpl<View>()

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

    abstract fun justCreate(context: Context, data: BaseComponentData): Component<out View>

    open fun createCompletely(context: Context, data: BaseComponentData): Component<out View> {
        return justCreate(context, data).also {
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

private class OnClickActionsAssignor(override val actions: List<ActionInvoker>) : ActionsAssignor {
    override fun assign(destination: View) {
        destination.setOnClickListener {
            actions.forEach { action ->
                action()
            }
        }
    }
}

private class OnInitActionsAssignor(override val actions: List<ActionInvoker>) : ActionsAssignor {
    override fun assign(destination: View) {
        destination.doOnAttach {
            actions.forEach { action ->
                action()
            }
        }
    }
}