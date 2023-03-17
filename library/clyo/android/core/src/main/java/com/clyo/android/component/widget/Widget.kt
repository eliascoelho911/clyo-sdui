package com.clyo.android.component.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.clyo.android.ClyoDeclaration
import com.clyo.android.R
import com.clyo.android.action.ActionsAssignor
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentFactory

internal class Widget<T : View>(
    override val view: T,
    override val binder: ComponentBinder<T>,
    override val actionsAssignors: List<ActionsAssignor>
) : Component<T>()

internal class WidgetFactory(
    override val clyoDeclaration: ClyoDeclaration
) : ComponentFactory() {

    override fun justCreate(context: Context, data: BaseComponentData): Widget<*> {
        val viewProvider = clyoDeclaration.getViewProvider(data.name)

        return widget(
            view = viewProvider.provide(context),
            data = data,
        )
    }

    override fun createAndApplyProperties(
        context: Context,
        data: BaseComponentData
    ): Widget<*> {
        return super.createAndApplyProperties(context, data) as Widget<*>
    }

    private fun <T : View> widget(view: T, data: BaseComponentData): Widget<T> {
        return Widget(
            view = view,
            binder = getBinder(data.name),
            actionsAssignors = getActionsAssignors(data.actions)
        )
    }
}

class WidgetSlotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var ref: String? = null

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
                ref = getString(R.styleable.WidgetContainerView_ref)
            } finally {
                recycle()
            }
        }
    }

    companion object {
        const val name = "clyo:widget_slot"
    }
}