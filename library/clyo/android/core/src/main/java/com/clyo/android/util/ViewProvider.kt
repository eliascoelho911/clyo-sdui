package com.clyo.android.util

import android.content.Context
import android.view.View
import kotlin.reflect.KClass

interface ViewProvider {
    fun provide(context: Context): View
}

@PublishedApi
internal class ViewProviderWithReflection(private val viewKClass: KClass<out View>): ViewProvider {
    override fun provide(context: Context): View {
        return viewKClass.createViewInstance(context)
    }
}

internal fun provideView(
    provide: (Context) -> View
) = object : ViewProvider {
    override fun provide(context: Context): View = provide(context)
}

@Suppress("UNCHECKED_CAST")
private fun <T : View> KClass<T>.createViewInstance(context: Context): T {
    return java.constructors.first().newInstance(context) as T
}