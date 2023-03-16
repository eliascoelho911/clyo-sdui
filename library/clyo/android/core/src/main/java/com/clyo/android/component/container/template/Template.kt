package com.clyo.android.component.container.template

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.children
import com.clyo.android.ClyoDeclarations
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.container.CreateContainer
import com.clyo.android.component.emptyBinder
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.properties.PropertiesData
import com.clyo.android.component.properties.propertiesData
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.component.widget.WidgetSlotView
import kotlinx.serialization.json.JsonPrimitive

interface ClyoTemplateContainer : ClyoContainer {
    override fun addWidget(view: View, layoutProperties: BasePropertiesData) {
        applyLayoutProperties(view, layoutProperties)

        val position = layoutProperties.getStringOrNull("position") ?: error("position not found")

        viewGroup.children.forEach { childView ->
            if (childView is WidgetSlotView && childView.positionId == position) {
                childView.addView(view)
                return
            }
        }

        error("No widget with position $position was declared in the template")
    }
}

private class ClyoTemplateContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), ClyoTemplateContainer {
    override val viewGroup: ViewGroup = this
}

internal class TemplateCreator(
    private val clyoDeclarations: ClyoDeclarations,
    private val createContainer: CreateContainer,
    private val context: Context
) {
    operator fun invoke(data: BaseTemplateData) {
        declare(data)

        val container = createContainer(context, data.toContainerData())
    }

    private fun declare(data: BaseTemplateData) {
        clyoDeclarations.putBinder(ComponentName(data.name)) { emptyBinder() }
        clyoDeclarations.putViewKClass(ComponentName(data.name), ClyoTemplateContainerView::class)
    }
}

private fun BaseTemplateData.toContainerData() = ContainerData(
    name = ComponentName(name),
    content = content.map { widgetSlotData ->
        WidgetData(
            name = ComponentName(WidgetSlotView.name),
            properties = widgetSlotData.properties as PropertiesData,
            layoutProperties = layoutPropertiesOfWidget(widgetSlotData)
        )
    }
)

private fun layoutPropertiesOfWidget(widgetSlotData: BaseWidgetSlotData) = propertiesData(
    mapOf("position" to JsonPrimitive(widgetSlotData.ref))
)