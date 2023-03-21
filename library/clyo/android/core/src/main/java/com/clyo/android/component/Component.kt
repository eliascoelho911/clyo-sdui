package com.clyo.android.component

import android.content.Context
import android.view.View
import androidx.core.view.doOnAttach
import com.clyo.android.ClyoDeclaration
import com.clyo.android.action.ActionInvoker
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.action.BaseActionData
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

//Todo Deve ser internal
@JvmInline
value class ComponentBinder<T : View>(
    private val binderBlock: T.(properties: BasePropertiesData) -> Unit = {}
) {
    fun bind(properties: BasePropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}

internal fun ComponentBinder<*>?.orEmpty(): ComponentBinder<out View> {
    return this ?: emptyBinder()
}

internal fun emptyBinder(): ComponentBinder<*> = ComponentBinder<View>()

internal abstract class ComponentFactory {

    protected abstract val clyoDeclaration: ClyoDeclaration

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> getBinder(name: ComponentName): ComponentBinder<T> {
        return clyoDeclaration.getBinderOrNull(name).orEmpty() as ComponentBinder<T>
    }

    protected fun getActionsAssignors(actions: BaseActionsData): List<ActionsAssignor> {
        val onClickActions = actions.onClick.actionInvokers(clyoDeclaration)
        val onClickActionsAssignor = OnClickActionsAssignor(onClickActions)

        val onInitActions = actions.onInit.actionInvokers(clyoDeclaration)
        val onInitActionsAssignor = OnInitActionsAssignor(onInitActions)

        return listOf(onClickActionsAssignor, onInitActionsAssignor)
    }

    abstract fun justCreate(context: Context, data: BaseComponentData): Component<out View>

    open fun createAndApplyProperties(
        context: Context,
        data: BaseComponentData
    ): Component<out View> {
        return justCreate(context, data).also {
            it.setup(properties = data.properties)
        }
    }
}

private fun List<BaseActionData>.actionInvokers(clyoDeclaration: ClyoDeclaration): List<ActionInvoker> {
    return mapNotNull { actionData ->
        val action = clyoDeclaration.getActionOrNull(actionData.name)
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