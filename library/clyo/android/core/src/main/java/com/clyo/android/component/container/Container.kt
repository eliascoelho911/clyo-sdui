package com.clyo.android.component.container

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.children
import com.clyo.android.BaseClyoData
import com.clyo.android.ClyoDeclaration
import com.clyo.android.ClyoEngine
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.container.template.WidgetSlotView
import com.clyo.android.component.container.view.applyDefaultLayoutProperties
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.BaseWidgetData
import com.clyo.android.component.widget.Widget
import com.clyo.android.component.widget.WidgetFactory

//TODO Desacoplar essa interface de template
interface ClyoContainer {
    val viewGroup: ViewGroup

    var isTemplate: Boolean

    fun applyLayoutPropertiesOnWidget(view: View, layoutProperties: BasePropertiesData) {
        view.applyDefaultLayoutProperties(layoutProperties)
    }

    //TODO Substituir view por widget
    fun addWidget(view: View, layoutProperties: BasePropertiesData) {
        applyLayoutPropertiesOnWidget(view, layoutProperties)
        if (isTemplate) addWidgetOnTemplate(view, layoutProperties) else viewGroup.addView(view)
    }

    private fun addWidgetOnTemplate(view: View, layoutProperties: BasePropertiesData) {
        val ref = layoutProperties.getStringOrNull("ref") ?: error("ref not found")

        viewGroup.children.forEach { childView ->
            if (childView is WidgetSlotView && childView.ref == ref) {
                childView.show(view)
                return
            }
        }

        error("No widget with ref $ref was declared in the template")
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
    override val clyoDeclaration: ClyoDeclaration
) : ComponentFactory() {

    override fun justCreate(context: Context, data: BaseComponentData): Container<*> {
        val viewProvider = clyoDeclaration.getViewProvider(data.name)

        return container(
            data = data,
            viewGroup = viewProvider.provide(context) as ViewGroup
        )
    }

    override fun createAndApplyProperties(context: Context, data: BaseComponentData): Container<*> {
        return super.createAndApplyProperties(context, data) as Container<*>
    }

    private fun <T : ViewGroup> container(data: BaseComponentData, viewGroup: T): Container<T> {
        return Container(
            view = viewGroup,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}

internal fun ClyoEngine.createContainer(
    context: Context,
    data: BaseContainerData
): Container<*> {
    val containerFactory = ContainerFactory(clyoDeclaration)
    val widgetFactory = WidgetFactory(clyoDeclaration)

    return createContainer(context, containerFactory, widgetFactory, data)
}

private fun createContainer(
    context: Context,
    containerFactory: ContainerFactory,
    widgetFactory: WidgetFactory,
    data: BaseContainerData
): Container<*> {
    val container = containerFactory.createAndApplyProperties(context, data)

    data.content.forEach { widgetData ->
        container.showWidget(
            widgetFactory = widgetFactory,
            data = widgetData
        )
    }

    return container
}

private fun Container<*>.showWidget(
    widgetFactory: WidgetFactory,
    data: BaseWidgetData
) {
    val widget = widgetFactory.createAndApplyProperties(
        context = view.context,
        data = data
    )
    addWidget(widget, data.layoutProperties)
}

fun ClyoEngine.showClyoScreen(
    parent: ViewGroup,
    data: BaseClyoData
) {
    val containerFactory = ContainerFactory(clyoDeclaration)
    val widgetFactory = WidgetFactory(clyoDeclaration)

    showClyoScreen(
        containerFactory,
        widgetFactory,
        parent,
        data
    )
}

private fun showClyoScreen(
    containerFactory: ContainerFactory,
    widgetFactory: WidgetFactory,
    parent: ViewGroup,
    data: BaseClyoData
) {
    val rootContainer = createContainer(
        context = parent.context,
        containerFactory = containerFactory,
        widgetFactory = widgetFactory,
        data = data.root
    )
    parent.addView(rootContainer.view)
}