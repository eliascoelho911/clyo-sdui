package com.eliascoelho911.clyo.sample.di

import com.eliascoelho911.clyo.sample.data.repository.ClyoSampleRepositoryImpl
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.data.service.GetClyoTemplateContent
import com.eliascoelho911.clyo.sample.presentation.ClyoSampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val SampleModule = module {
    viewModel {
        ClyoSampleViewModel(
            repository = ClyoSampleRepositoryImpl(
                getClyoSampleScreenContent = GetClyoSampleScreenContent(),
                getClyoTemplateContent = GetClyoTemplateContent()
            )
        )
    }
}