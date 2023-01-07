package com.clyo.android.util

import android.content.Context
import android.view.View
import kotlin.reflect.KClass

fun <T : View> KClass<T>.createViewInstance(context: Context): T {
    return constructors.first().call(context)
}