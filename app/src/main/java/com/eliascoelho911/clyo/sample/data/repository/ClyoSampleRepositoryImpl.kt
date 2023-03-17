package com.eliascoelho911.clyo.sample.data.repository

import com.clyo.android.ClyoData
import com.clyo.android.component.container.template.ClyoTemplateData
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.data.service.GetClyoTemplateContent
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository

internal class ClyoSampleRepositoryImpl(
    private val getClyoSampleScreenContent: GetClyoSampleScreenContent,
    private val getClyoTemplateContent: GetClyoTemplateContent
) : ClyoSampleRepository {
    override fun getScreenContent(): ClyoData = getClyoSampleScreenContent()

    override fun getTemplate(): ClyoTemplateData = getClyoTemplateContent()
}