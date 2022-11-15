package com.clyo.core.android.annotation

import com.eliascoelho911.clyo.ComponentName

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class DeclareComponentViewFactory(val name: ComponentName)
