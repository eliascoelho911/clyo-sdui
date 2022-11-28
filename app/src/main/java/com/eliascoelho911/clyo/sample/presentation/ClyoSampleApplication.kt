package com.eliascoelho911.clyo.sample.presentation

import android.app.Application
import com.clyo.core.startClyo
import com.eliascoelho911.clyo.sample.di.SampleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class ClyoSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ClyoSampleApplication)
            modules(SampleModule)
        }
        startClyo(ClyoSampleModule)
    }
}