package com.eliascoelho911.clyo.sample.data.repository

import com.eliascoelho911.clyo.ScreenData
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository

internal class ClyoSampleRepositoryImpl(
    private val service: GetClyoSampleScreenContent
) : ClyoSampleRepository {
    override fun getScreenContent(): ScreenData = service()
}