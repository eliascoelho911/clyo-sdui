package com.eliascoelho911.clyo.sample.data.repository

import com.eliascoelho911.clyo.android.components.ButtonData
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.model.ClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository

internal class ClyoSampleRepositoryImpl(
    private val service: GetClyoSampleScreenContent
) : ClyoSampleRepository {
    override fun getScreenContent(): ClyoSampleScreenContent {
        return ClyoSampleScreenContent(
            content = ButtonData(
                text = "Bora fazer a melhor lib de SDUI do MUNDO????",
                styleRes = null
            )
        )
    }
}