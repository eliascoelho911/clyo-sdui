package com.clyo.android.widgets.material3

import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.action.Action
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.applyButtonViewProperties
import com.clyo.android.component.widget.applyTextViewProperties
import com.clyo.android.component.widget.applyViewProperties
import com.clyo.android.dsl.clyoDeclaration

val ClyoWidgetsModule = clyoDeclaration {
    widget<AppCompatImageView>("image") { properties ->
        applyViewProperties(properties)
    }

    widget<AppCompatTextView>("text") { properties ->
        applyTextViewProperties(properties)
    }

    widget<AppCompatButton>("button") { properties ->
        applyButtonViewProperties(properties)
    }

    action("test") {
        object : Action {
            override fun invoke(properties: BasePropertiesData) {
                Log.i("ACTION_TEST", "Funcionou ${properties.getString("test")}")
            }
        }
    }
}