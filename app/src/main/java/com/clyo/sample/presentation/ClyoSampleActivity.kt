package com.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.ui.clyoEngine
import com.clyo.sample.R
import com.clyo.sample.databinding.ActivityClyoSampleBinding
import com.clyo.sample.stub.ClyoSampleJson
import com.clyo.sample.stub.ConsolidatedJsonStub
import com.clyo.sample.stub.ContainerFactoryImpl
import com.clyo.sample.stub.WidgetFactoryImpl

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoContainerView)
        ActivityClyoSampleBinding.bind(root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val clyoEngine = clyoEngine {
            json(ClyoSampleJson)
            widgetProvider(WidgetFactoryImpl())
            containerProvider(ContainerFactoryImpl())
        }
        val container = clyoEngine.create(this, ConsolidatedJsonStub.json.content)

        binding.clyoContainerView.addView(container.getView())

        clyoEngine.render(container, ConsolidatedJsonStub.json.properties)
    }
}

