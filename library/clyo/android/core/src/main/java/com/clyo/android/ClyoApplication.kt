package com.clyo.android

import android.content.Context
import com.clyo.android.view.renderer.ViewBinderModule
import com.clyo.android.view.renderer.ViewClassModule
import com.clyo.core.Clyo
import com.clyo.core.ClyoApplication
import com.clyo.core.ClyoInstanceManager
import com.clyo.core.annotation.ClyoInternalAPI

class ClyoAndroidApplication internal constructor(
    private val context: Context
) : ClyoApplication {
    private val viewBinderModule = ViewBinderModule()

    private val viewClassModule = ViewClassModule()

    override fun createClyo(): Clyo = ClyoAndroid(
        context, viewBinderModule, viewClassModule
    )

    override fun stop() {
        viewBinderModule.clear()
    }
}

@OptIn(ClyoInternalAPI::class)
fun startClyo(context: Context) {
    ClyoInstanceManager.application = ClyoAndroidApplication(context)
}