package com.clyo.android.component.container.template

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.clyo.android.ClyoEngine
import com.clyo.android.R
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.container.createContainer
import com.clyo.android.component.properties.propertiesData
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.dsl.clyoDeclaration
import kotlinx.serialization.json.JsonPrimitive

class WidgetSlotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var ref: String? = null

    init {
        setupAttrs(context, attrs)
    }

    fun show(view: View) {
        removeAllViews()

        view.layoutParams = LayoutParams(layoutParams.width, layoutParams.height)

        addView(view)
    }

    private fun setupAttrs(context: Context, attrs: AttributeSet?) {
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

//TODO Tirar isso daqui
val ClyoTemplateDeclaration = clyoDeclaration {
    widget<WidgetSlotView>(WidgetSlotView.name) { properties ->
        ref = properties.getString("ref")
    }
}

//TODO Garantir que isso não de memory leak
fun ClyoEngine.createDeclarationToTemplate(templateData: BaseClyoTemplateData) = clyoDeclaration {
    container(name = templateData.name, provide = { context ->
        createTemplateContainer(context, templateData)
    })
}

private fun ClyoEngine.createTemplateContainer(
    context: Context,
    templateData: BaseClyoTemplateData
): ViewGroup {
    val containerView = createContainer(
        context,
        data = templateData.toContainerData()
    ).view as ClyoContainer

    containerView.isTemplate = true

    return containerView.viewGroup
}

private fun BaseClyoTemplateData.toContainerData() = ContainerData(
    name = ComponentName(rootName),
    content = content.map {
        WidgetData(
            name = ComponentName(WidgetSlotView.name),
            layoutProperties = it.layoutProperties,
            //TODO No caso do root ser o Column, aplicar o ref como sendo a posição do widget na lista
            properties = propertiesData(mapOf("ref" to JsonPrimitive(it.ref)))
        )
    }
)
