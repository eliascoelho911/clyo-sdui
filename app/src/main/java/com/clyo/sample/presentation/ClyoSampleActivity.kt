package com.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.scope.provider.clyo
import com.clyo.sample.R
import com.clyo.sample.databinding.ActivityClyoSampleBinding
import com.clyo.sample.stub.ClyoJsonStub

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoContainerView)
        ActivityClyoSampleBinding.bind(root)
    }

    private val clyo by clyo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clyo.submit(ClyoJsonStub.json, binding.clyoContainerView)
    }
}

