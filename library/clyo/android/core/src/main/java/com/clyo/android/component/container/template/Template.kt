package com.clyo.android.component.container.template

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.children
import com.clyo.android.ClyoDeclaration
import com.clyo.android.ClyoEngine
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.WidgetSlotView
import com.clyo.android.component.widget.applyDefaultLayoutProperties
import com.clyo.android.dsl.clyoDeclaration
import kotlin.reflect.KClass

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

internal val clyoTemplateDeclaration = clyoDeclaration {
    widget<WidgetSlotView>("clyo:widget_slot") { properties ->
        applyDefaultLayoutProperties(properties)
    }
}

fun ClyoEngine.createDeclarationToTemplate(templateData: BaseTemplateData): ClyoDeclaration {
    return createDeclarationToTemplate(
        templateName = templateData.name,
        viewKClass = clyoDeclaration.getViewKClass(ComponentName(templateData.rootName))
    )
}

@Suppress("UNCHECKED_CAST")
private fun createDeclarationToTemplate(
    templateName: String,
    viewKClass: KClass<out View>
) = clyoDeclaration {
    val rootKClass = viewKClass as KClass<out ViewGroup>

    container(name = templateName, viewKClass = rootKClass)
}