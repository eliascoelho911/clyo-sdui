package com.clyo.android.component.widget

import com.clyo.android.action.ActionsData
import com.clyo.android.component.BaseComponentData
import com.clyo.android.component.ComponentName
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.properties.PropertiesData
import com.clyo.android.util.serializer.ComponentNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

interface BaseWidgetData : BaseComponentData {
    val layoutProperties: BasePropertiesData
}

@Serializable
data class WidgetData(
    //TODO Trocar ComponentName para typealias de string
    @SerialName("name")
    @Serializable(with = ComponentNameAsStringSerializer::class)
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: PropertiesData = PropertiesData(JsonObject(mapOf())),
    //TODO Se container for template, o layout_properties não será enviado e widget recebá o ref diretamente
    @SerialName("layout_properties")
    override val layoutProperties: PropertiesData = PropertiesData(JsonObject(mapOf())),
    @SerialName("actions")
    override val actions: ActionsData = ActionsData()
) : BaseWidgetData