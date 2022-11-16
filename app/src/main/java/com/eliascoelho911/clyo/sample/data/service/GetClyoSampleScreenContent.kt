package com.eliascoelho911.clyo.sample.data.service

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.serializers.kotlinx.serialization.ComponentDataKS
import com.clyo.serializers.kotlinx.serialization.LayoutDataKS
import com.eliascoelho911.clyo.ComponentProperties
import com.eliascoelho911.clyo.ScreenData

internal class GetClyoSampleScreenContent {
    operator fun invoke() = ScreenData(
        content = LayoutDataKS(
            name = "layout.column",
            properties = ComponentProperties(
                mapOf(
                    "orientation" to LinearLayoutCompat.VERTICAL
                )
            ),
            content = listOf(
                ComponentDataKS(
                    name = "android.button",
                    properties = ComponentProperties(
                        mapOf(
                            "text" to "Bora fazer a melhor lib de SDUI do MUNDO????"
                        )
                    )
                ),
                ComponentDataKS(
                    name = "android.button",
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