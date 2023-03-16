package com.clyo.android.component.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.clyo.android.ClyoDeclarations
import com.clyo.android.R
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentFactory
import com.clyo.android.util.createViewInstance

internal class Widget<T : View>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>()

internal class WidgetFactory(
    override val clyoDeclarations: ClyoDeclarations
) : ComponentFactory() {
    override fun justCreate(context: Context, data: BaseComponentData): Widget<*> {
        val viewKClass = clyoDeclarations.getViewKClassOrNull(data.name)
            ?: error("Widget $data.name has not been declared")

        return widget(
            view = viewKClass.createViewInstance(context),
            data = data,
        )
    }

    override fun createCompletely(
        context: Context,
        data: BaseComponentData
    ): Widget<*> {
        return super.createCompletely(context, data) as Widget<*>
    }

    private fun <T : View> widget(view: T, data: BaseComponentData): Widget<T> {
        return Widget(
            view = view,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}

internal class CreateWidget(
    private val widgetFactory: WidgetFactory
) {
    operator fun invoke(context: Context, data: BaseWidgetData): Widget<*> {
        return widgetFactory.createCompletely(
            context = context,
            data = data
        )
    }
}

class WidgetSlotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var positionId: String? = null

    init {
        getAttrs(context, attrs)
    }

    private fun getAttrs(context: Context, attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.WidgetContainerView,
            0, 0
        ).apply {
            try {
                positionId = getString(R.styleable.WidgetContainerView_position)
            } finally {
                recycle()
            }
        }
    }

    companion object {
        const val name = "widget_slot"
    }
}