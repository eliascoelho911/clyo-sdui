package com.eliascoelho911.clyo.sample.data.service

import com.clyo.serializers.kotlinx.serialization.PropertyValueKS
import com.eliascoelho911.clyo.sample.data.model.ClyoComponentData
import kotlinx.serialization.json.JsonPrimitive

internal class GetClyoSampleScreenContent {
    operator fun invoke() = ClyoComponentData(
        name = "android.button",
        properties = mapOf(
            "text" to PropertyValueKS(JsonPrimitive("Bora fazer a melhor lib de SDUI do MUNDO????"))
        )
    )
}