package com.clyo.android.util

import android.content.Context
import android.view.View
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : View> KClass<T>.createViewInstance(context: Context): T {
    return java.constructors.first().newInstance(context) as T
}