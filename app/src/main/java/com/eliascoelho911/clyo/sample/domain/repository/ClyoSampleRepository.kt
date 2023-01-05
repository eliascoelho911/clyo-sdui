package com.eliascoelho911.clyo.sample.domain.repository

import com.clyo.serializer.kotlinxserialization.ClyoData

internal interface ClyoSampleRepository {
    fun getScreenContent(): ClyoData
}