package com.eliascoelho911.clyo.sample.domain.repository

import com.clyo.android.ClyoData

internal interface ClyoSampleRepository {
    fun getScreenContent(): ClyoData
}