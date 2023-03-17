package com.eliascoelho911.clyo.sample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clyo.android.ClyoData
import com.clyo.android.component.container.template.ClyoTemplateData
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository
import kotlinx.coroutines.delay

internal class ClyoSampleViewModel(
    private val repository: ClyoSampleRepository,
) : ViewModel() {
    val screenContent: LiveData<ClyoData> = liveData {
        delay(2000)
        emit(repository.getScreenContent())
    }
    val templateContent: LiveData<ClyoTemplateData> = liveData {
        emit(repository.getTemplate())
    }
}