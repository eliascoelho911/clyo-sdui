package com.eliascoelho911.clyo.sample.data.repository

import com.clyo.serializers.kotlinx.serialization.PropertyValueKS
import com.eliascoelho911.clyo.sample.data.model.ClyoComponentData
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.model.ClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository
import kotlinx.serialization.json.JsonPrimitive

internal class ClyoSampleRepositoryImpl(
    private val service: GetClyoSampleScreenContent
) : ClyoSampleRepository {
    override fun getScreenContent(): ClyoSampleScreenContent {
        return ClyoSampleScreenContent(
            content = ClyoComponentData(
                name = "android.button",
                properties = mapOf(
                    "text" to PropertyValueKS(
                        JsonPrimitive("Bora fazer a melhor lib de SDUI do MUNDO????")
                    )
                )
            )
        )
    }
}