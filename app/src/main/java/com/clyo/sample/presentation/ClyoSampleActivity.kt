package com.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.scope.provider.clyo
import com.clyo.component.container.ContainerData
import com.clyo.component.type.ComponentType
import com.clyo.component.widget.WidgetData
import com.clyo.page.PageData
import com.clyo.sample.R
import com.clyo.sample.databinding.ActivityClyoSampleBinding
import com.clyo.sample.presentation.components.widgets.TextProperties

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoPageHolderView)
        ActivityClyoSampleBinding.bind(root)
    }

    private val clyo by clyo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stub = PageData(
            content = ContainerData(
                type = ComponentType("column"),
                content = listOf(
                    WidgetData(
                        type = ComponentType("text"),
                        args = TextProperties(
                            text = "Hello, World!",
                            textSize = 20f
                        )
                    )
                )
            )
        )
        val page = clyo.page(stub)
        binding.clyoPageHolderView.show(page)
    }
}