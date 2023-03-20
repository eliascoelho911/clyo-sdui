package com.clyo.android.component.container.view

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.annotation.GravityInt
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams
import androidx.core.view.updateLayoutParams
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.properties.BasePropertiesData
import kotlin.math.roundToInt

internal class ColumnContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    override val viewGroup: ViewGroup = this

    override var isTemplate: Boolean = false

    override fun applyLayoutPropertiesOnWidget(view: View, layoutProperties: BasePropertiesData) {
        view.applyDefaultLayoutProperties(layoutProperties)
    }

    init {
        orientation = VERTICAL
    }
}

internal fun View.applyDefaultLayoutProperties(layoutProperties: BasePropertiesData) {
    applySize(layoutProperties)
    applyMargin(layoutProperties)
    applyGravity(layoutProperties)
}

//TODO Possibilitar o envio de keys modificadoras para WRAP_CONTENT E MATCH_PARENT
private fun View.applySize(layoutProperties: BasePropertiesData) {
    ensureLayoutParamsIsNotNull()

    val size = layoutProperties.getIntMap("size")

    updateLayoutParams<LayoutParams> {
        size["width"]?.toPx()?.let { width = it }
        size["height"]?.toPx()?.let { height = it }
    }
}

//TODO Refatorar para função não ser uma global extented funcion
private fun View.applyMargin(layoutProperties: BasePropertiesData) {
    ensureLayoutParamsIsNotNull()

    val margins = layoutProperties.getIntMap("margin")

    updateLayoutParams<LayoutParams> {
        setMargins(
            margins["start"].orZero().toPx(),
            margins["top"].orZero().toPx(),
            margins["end"].orZero().toPx(),
            margins["bottom"].orZero().toPx()
        )
    }
}

private fun View.applyGravity(layoutProperties: BasePropertiesData) {
    ensureLayoutParamsIsNotNull()

    val gravityValue = layoutProperties.getStringOrNull("gravity").toGravityOrNull()

    if (gravityValue != null) {
        updateLayoutParams<LayoutParams> {
            this.gravity = gravityValue
        }
    }
}

private enum class GravityEnum(@GravityInt val value: Int) {
    CENTER(Gravity.CENTER),
    CENTER_HORIZONTAL(Gravity.CENTER_HORIZONTAL),
    CENTER_VERTICAL(Gravity.CENTER_VERTICAL),
    START(Gravity.START),
    END(Gravity.END),
    TOP(Gravity.TOP),
    BOTTOM(Gravity.BOTTOM);
}

private fun String?.toGravityOrNull(): Int? = runCatching {
    GravityEnum.valueOf(this!!).value
}.getOrNull()

private const val DEFAULT_WIDTH = MATCH_PARENT
private const val DEFAULT_HEIGHT = WRAP_CONTENT

private fun View.ensureLayoutParamsIsNotNull() {
    if (layoutParams == null)
        layoutParams = LayoutParams(DEFAULT_WIDTH, DEFAULT_HEIGHT)
}

private fun Int?.orZero(): Int = this ?: 0

private fun Int.toPx(): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).roundToInt()
}
