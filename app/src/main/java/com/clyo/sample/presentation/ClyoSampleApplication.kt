package com.clyo.sample.presentation

import android.app.Application
import com.clyo.android.startClyo
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class ClyoSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ClyoSampleApplication)
        }

        startClyo {
            widgetProvider = ClyoWidgetProviderImpl()
            containerProvider = ClyoContainerProviderImpl()
        }
    }
}