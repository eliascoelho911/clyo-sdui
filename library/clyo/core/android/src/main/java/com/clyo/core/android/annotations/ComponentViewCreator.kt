package com.clyo.core.android.annotations

import android.view.View
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ComponentViewCreator(val name: String, val viewKlass: KClass<out View>)