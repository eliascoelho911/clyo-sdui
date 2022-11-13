package com.eliascoelho911.clyo.annotations

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DeclareProperty(
    val key: String,
    val type: KClass<*>
)