package com.eliascoelho911.clyo.sample.domain.repository

import com.clyo.core.data.ScreenData

internal interface ClyoSampleRepository {
    fun getScreenContent(): ScreenData
}