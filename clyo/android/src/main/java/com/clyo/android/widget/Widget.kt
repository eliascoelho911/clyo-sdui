package com.clyo.android.widget

import android.content.Context
import android.view.View
import com.clyo.android.common.newInstance
import com.clyo.data.properties.PropertiesJson
import kotlin.reflect.KClass

class Widget<T : View> internal constructor(
    private val viewKClass: KClass<T>,
    private val binder: WidgetBinder<T>
) {
    private var _view: T? = null

    val view: T get() = _view ?: throw IllegalStateException("View not created")

    fun render(context: Context, propertiesJson: PropertiesJson): View {
        createViewIfNeeded(context)

        binder.assign(view, propertiesJson)

        return view
    }

    private fun createViewIfNeeded(context: Context) {
        if (_view == null) createView(context)
    }

    private fun createView(context: Context) {
        _view = viewKClass.newInstance(context)
    }
}