package com.clyo.core.android

import android.content.Context
import android.view.View
import android.widget.Button
import com.eliascoelho911.clyo.data.component.ComponentName

object ViewProvider {

    @Suppress("UNCHECKED_CAST")
    fun <T : View> provideByComponentName(context: Context, componentName: ComponentName): T {
        return when (componentName) {
            "android.button" -> Button(context)
            else -> View(context)
        } as T
    }
}