package com.eliascoelho911.clyo.sample.domain.repository

import com.eliascoelho911.clyo.ScreenData

internal interface ClyoSampleRepository {
    fun getScreenContent(): ScreenData
}