package com.eliascoelho911.clyo.sample.data.service

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.data.ComponentProperties
import com.clyo.core.data.ScreenData
import com.clyo.core.data.kotlinx.serialization.data.ComponentData
import com.clyo.core.data.kotlinx.serialization.data.LayoutData

internal class GetClyoSampleScreenContent {
    operator fun invoke() = ScreenData(
        content = LayoutData(
            name = "column",
            properties = ComponentProperties(
                mapOf(
                    "orientation" to LinearLayoutCompat.HORIZONTAL
                )
            ),
            content = listOf(
                ComponentData(
                    name = "button",
                    properties = ComponentProperties(
                        mapOf(
                            "text" to "Bora fazer a melhor lib de SDUI do MUNDO????"
                        )
                    )
                ),
                ComponentData(
                    name = "button",
                    properties = ComponentProperties(
                        mapOf(
                            "text" to "BORA DEMAAAAIS!"
                        )
                    )
                )
            )
        )
    )
}