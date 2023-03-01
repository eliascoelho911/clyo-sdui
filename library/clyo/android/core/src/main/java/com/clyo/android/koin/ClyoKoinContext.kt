package com.clyo.android.koin

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

internal object ClyoKoinContext {
    lateinit var koinApplication: KoinApplication

    fun initKoin(context: Context) {
        koinApplication = startKoin {
            androidContext(context)
        }
    }
}

internal interface ClyoKoinComponent : KoinComponent {
    override fun getKoin(): Koin {
        return ClyoKoinContext.koinApplication.koin
    }
}