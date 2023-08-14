package com.clyo.sample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clyo.sample.SampleManager

internal class ClyoSampleViewModel : ViewModel() {
    private val pageJsonLiveData = MutableLiveData(SampleManager.getPageJson())

    fun getPageJson(): LiveData<String> = pageJsonLiveData
}