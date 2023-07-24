package com.clyo.component

sealed interface Component<V : Any> {
    val value: V
}