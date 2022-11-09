package com.eliascoelho911.clyo.core.data.component

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindProperty(val name: String)
