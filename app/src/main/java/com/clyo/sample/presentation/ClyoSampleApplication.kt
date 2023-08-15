package com.clyo.sample.presentation

import android.app.Application
import com.clyo.android.ClyoApplication
import com.clyo.sample.di.koinModule
import com.clyo.sample.presentation.components.widgets.TextProperties
import com.clyo.sample.presentation.providers.ClyoContainerProviderImpl
import com.clyo.sample.presentation.providers.ClyoWidgetProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class ClyoSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ClyoSampleApplication)
            modules(koinModule)
        }

        ClyoApplication.start(
            widgetProvider = ClyoWidgetProviderImpl(),
            containerProvider = ClyoContainerProviderImpl(),
            widgetPropertiesKSerializerMap = mapOf(
                TextProperties::class to TextProperties.serializer()
            )
        )
    }
}