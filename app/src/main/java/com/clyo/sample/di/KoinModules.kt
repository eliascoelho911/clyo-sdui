package com.clyo.sample.di

import com.clyo.sample.presentation.ClyoSampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val koinModule = module {
    viewModel {
        ClyoSampleViewModel()
    }
}