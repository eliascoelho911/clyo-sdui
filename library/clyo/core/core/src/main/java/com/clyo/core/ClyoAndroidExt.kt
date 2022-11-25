package com.clyo.core

import android.app.Activity
import com.clyo.core.component.renderer.ComponentRendererProvider

fun Activity.startClyo(componentRendererProvider: ComponentRendererProvider) {
    Clyo.start(
        screenRenderer = ScreenRenderer(
            componentRendererProvider
        )
    )
}
//
//fun Fragment.startClyo() {
//    Clyo.start(
//        screenRenderer = ScreenRenderer(
//            rootView = requireView() as? ViewGroup ?: error("The root view must be a ViewGroup")
//        )
//    )
//}