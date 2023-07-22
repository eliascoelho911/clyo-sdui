package com.clyo.sample.presentation

import android.app.Application
import com.clyo.android.startClyo
import com.clyo.sample.impl.ClyoSampleJson
import com.clyo.sample.impl.container.ContainerProviderImpl
import com.clyo.sample.impl.widget.WidgetProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class ClyoSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ClyoSampleApplication)
        }

        startClyo {
            containerProvider = ContainerProviderImpl()
            widgetProvider = WidgetProviderImpl()
            json = ClyoSampleJson
        }
    }
}