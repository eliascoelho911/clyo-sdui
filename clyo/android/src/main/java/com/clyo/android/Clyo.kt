package com.clyo.android

import android.view.ViewGroup
import com.clyo.android.ui.ClyoScreen
import com.clyo.android.ui.clyoScreen
import com.clyo.android.ui.render
import com.clyo.android.ui.showOnViewGroup
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson

// Todo: Essa camada ficou desnecessária. Pode ser removida.
class Clyo internal constructor() {

    private var _screen: ClyoScreen? = null

    private val screen: ClyoScreen
        get() = _screen ?: screenNotCreatedError()

    fun init(type: ContainerJson) {
        _screen = clyoScreen(type)
    }

    fun show(into: ViewGroup) {
        screen.showOnViewGroup(into)
    }

    fun render(propertiesJson: PropertiesJson) {
        screen.render(propertiesJson)
    }
}

fun Clyo.show(into: ViewGroup, properties: PropertiesJson) {
    show(into)
    render(properties)
}

fun clyo(): Clyo = Clyo()

private fun screenNotCreatedError(): Nothing {
    throw IllegalStateException("Screen root is not created. Use show()")
}