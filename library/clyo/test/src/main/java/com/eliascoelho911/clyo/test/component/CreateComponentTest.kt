package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.core.Component
import com.eliascoelho911.clyo.core.data.ComponentData
import com.eliascoelho911.clyo.core.data.converter.createComponent
import kotlin.reflect.KClass

inline fun <reified T : Component> ComponentData.assertCreationSuccess(componentClazz: KClass<T>) {
    runCatching {
        createComponent(componentClazz)
    }.onFailure {
        throw AssertionError(
            "error on create ${componentClazz.java.simpleName} with data ${this::class.java.simpleName}",
            it
        )
    }
}