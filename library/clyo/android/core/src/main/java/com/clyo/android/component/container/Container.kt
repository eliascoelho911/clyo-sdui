package com.clyo.android.component.container

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.clyo.android.BaseClyoData
import com.clyo.android.ClyoDeclarations
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.CreateWidget
import com.clyo.android.component.widget.Widget
import com.clyo.android.util.createViewInstance

interface ClyoContainer {
    val viewGroup: ViewGroup

    fun applyLayoutProperties(view: View, layoutProperties: BasePropertiesData) {}

    fun addWidget(view: View, layoutProperties: BasePropertiesData) {
        applyLayoutProperties(view, layoutProperties)
        viewGroup.addView(view)
    }
}

fun ClyoContainer.initContainer(@LayoutRes layoutRes: Int) {
    View.inflate(viewGroup.context, layoutRes, viewGroup)
}

internal class Container<T : ViewGroup>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>() {

    private val clyoContainer = view as ClyoContainer

    fun addWidget(widget: Widget<*>, layoutProperties: BasePropertiesData) {
        clyoContainer.addWidget(widget.view, layoutProperties)
    }
}

internal class ContainerFactory(
    override val clyoDeclarations: ClyoDeclarations
) : ComponentFactory() {
    override fun justCreate(context: Context, data: BaseComponentData): Container<*> {
        val viewKClass = clyoDeclarations.getViewKClassOrNull(data.name)
            ?: error("Container $data.name has not been declared")

        return container(
            data = data,
            viewGroup = viewKClass.createViewInstance(context) as ViewGroup
        )
    }

    override fun createCompletely(context: Context, data: BaseComponentData): Container<*> {
        return super.createCompletely(context, data) as Container<*>
    }

    private fun <T : ViewGroup> container(data: BaseComponentData, viewGroup: T): Container<T> {
        return Container(
            view = viewGroup,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}

internal class CreateContainer(
    private val containerFactory: ContainerFactory,
    private val widgetRenderer: CreateWidget
) {
    operator fun invoke(context: Context, data: BaseContainerData): Container<*> {
        val container = containerFactory.createCompletely(context, data)

        addChildren(data, container, context)

        return container
    }

    private fun addChildren(
        data: BaseContainerData,
        container: Container<*>,
        context: Context
    ) {
        data.content.forEach { widgetData ->
            container.addWidget(
                widget = widgetRenderer(context, widgetData),
                layoutProperties = widgetData.layoutProperties
            )
        }
    }
}

internal class ShowClyoScreen(
    private val createContainer: CreateContainer
) {
    operator fun invoke(data: BaseClyoData, parent: ViewGroup) {
        val rootView = createContainer(parent.context, data.root).view
        parent.addView(rootView)
    }
}