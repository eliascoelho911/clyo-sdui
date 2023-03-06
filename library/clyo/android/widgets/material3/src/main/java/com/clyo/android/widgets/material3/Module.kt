package com.clyo.android.widgets.material3

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.dsl.clyoComponents

val ClyoWidgetsModule = clyoComponents {
    widget<AppCompatImageView>("image") {
        binder { properties ->
            setImageWithUrl(properties.getStringOrNull("image_url").orEmpty())
            // Demais atribuições
        }
    }

    widget<AppCompatTextView>("text") {
        binder { properties ->
            text = properties.getStringOrNull("text")
        }
    }
}

private fun AppCompatImageView.setImageWithUrl(drawableName: String) {
    setBackgroundColor(Color.BLUE)
}

private fun getDrawableByName(drawableName: String): Drawable? {
    TODO("Not yet implemented")
}
