package com.clyo.android.component.container.template

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.ClyoEngine
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.container.createContainer
import com.clyo.android.component.properties.propertiesData
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.component.widget.WidgetSlotView
import com.clyo.android.dsl.clyoDeclaration
import kotlinx.serialization.json.JsonPrimitive

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

//TODO Passar o layoutProperties com o ref
private fun BaseClyoTemplateData.toContainerData() = ContainerData(
    name = ComponentName(rootName),
    content = content.map {
        WidgetData(
            name = ComponentName(WidgetSlotView.name),
            layoutProperties = it.layoutProperties,
            properties = propertiesData(mapOf("ref" to JsonPrimitive(it.ref)))
        )
    }
)
