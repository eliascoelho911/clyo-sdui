package com.clyo.android.widgets.material3

import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.action.Action
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.component.widget.binders.applyButtonViewProperties
import com.clyo.android.component.widget.binders.applyTextViewProperties
import com.clyo.android.component.widget.binders.applyViewProperties
import com.clyo.android.dsl.clyoDeclaration

val ClyoWidgetsModule = clyoDeclaration {
    widget<AppCompatImageView>("image") {
        binder { properties ->
            applyViewProperties(properties)
        }
    }

    widget<AppCompatTextView>("text") {
        binder { properties ->
            applyTextViewProperties(properties)
        }
    }

    widget<AppCompatButton>("button") {
        binder { properties ->
            applyButtonViewProperties(properties)
        }
    }

    action("test") {
        object : Action {
            override fun invoke(properties: BasePropertiesData) {
                Log.i("ACTION_TEST", "Funcionou ${properties.getString("test")}")
            }
        }
    }
}