package com.eliascoelho911.clyo.sample.domain.repository

import com.eliascoelho911.clyo.sample.domain.model.ClyoSampleScreenContent

internal interface ClyoSampleRepository {
    fun getScreenContent(): ClyoSampleScreenContent
}