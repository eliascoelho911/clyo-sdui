package com.clyo.android

import android.view.ViewGroup

// Todo: Receber ClyoContainerView ao invés de um ViewGroup
interface ClyoScope {
    val rootView: ViewGroup
}

interface LifecycleClyoScope : ClyoScope {
    val activity: ClyoActivity
}