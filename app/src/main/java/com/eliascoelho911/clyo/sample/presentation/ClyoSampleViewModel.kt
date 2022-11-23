package com.eliascoelho911.clyo.sample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clyo.core.data.ScreenData
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository

internal class ClyoSampleViewModel(
    private val repository: ClyoSampleRepository,
) : ViewModel() {
    val screenContent: LiveData<ScreenData> = liveData {
        emit(repository.getScreenContent())
    }
}