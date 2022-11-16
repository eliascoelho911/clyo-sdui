package com.eliascoelho911.clyo.sample.data.service

import com.eliascoelho911.clyo.ComponentProperties
import com.eliascoelho911.clyo.ScreenData
import com.eliascoelho911.clyo.sample.data.model.ClyoComponentData

internal class GetClyoSampleScreenContent {
    operator fun invoke() = ScreenData(
        content = ClyoComponentData(
            name = "android.button",
            properties = ComponentProperties(
                mapOf(
                    "text" to "Bora fazer a melhor lib de SDUI do MUNDO????"
                )
            )
        )
    )
}