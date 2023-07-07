package com.clyo.android.widgets.material3

import android.util.Log
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.TextViewCompat
import com.clyo.android.action.Action
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.applyButtonViewProperties
import com.clyo.android.component.widget.applyTextViewProperties
import com.clyo.android.component.widget.applyViewProperties
import com.clyo.android.dsl.clyoDeclaration
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textview.MaterialTextView

val ClyoWidgetsModule = clyoDeclaration {
    widget<AppCompatImageView>("material:image") { properties ->
        applyViewProperties(properties)
    }

    widget<MaterialTextView>("material:text") { properties ->
        applyTextViewProperties(properties)
        properties.getStringOrNull("style")?.toTextStyleOrNull()?.styleRes?.let {
            TextViewCompat.setTextAppearance(this, it)
        }
    }

    widget<AppCompatButton>("material:button") { properties ->
        applyButtonViewProperties(properties)
    }

    widget<MaterialToolbar>("material:toolbar")

    action("test") {
        object : Action {
            override fun invoke(properties: BasePropertiesData) {
                Log.i("ACTION_TEST", "Funcionou ${properties.getString("test")}")
            }
        }
    }
}

private enum class TextStyle(@StyleRes val styleRes: Int) {
    LARGE(com.google.android.material.R.style.TextAppearance_Material3_HeadlineSmall),
    NORMAL(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge);
}

private fun String.toTextStyleOrNull(): TextStyle? = runCatching {
    TextStyle.valueOf(this)
}.getOrNull()