package com.clyo.android.common

import android.content.Context
import android.view.View
import kotlin.reflect.KClass

// Todo: Fazer teste de performance para ver se vale a pena usar reflection
internal fun <T : View> KClass<T>.newInstance(context: Context): T {
    return constructors.firstOrNull { constructor ->
        constructor.parameters.filterNot { parameter ->
            parameter.isOptional
        }.size == 1
    }?.call(context) ?: throw ReflectiveOperationException("Could not create view")
}