package com.eliascoelho911.clyo.sample.domain.repository

import com.clyo.android.ClyoData
import com.clyo.android.component.container.template.ClyoTemplateData

internal interface ClyoSampleRepository {
    fun getScreenContent(): ClyoData
    fun getTemplate(): ClyoTemplateData
}