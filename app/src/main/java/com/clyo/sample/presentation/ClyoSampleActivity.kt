package com.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.ui.ClyoPage
import com.clyo.android.ui.clyoPage
import com.clyo.sample.R
import com.clyo.sample.databinding.ActivityClyoSampleBinding
import com.clyo.sample.stub.ClyoJsonStub

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoContainerView)
        ActivityClyoSampleBinding.bind(root)
    }

    private val clyoPage: ClyoPage by lazy { clyoPage() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clyoPage.submit(ClyoJsonStub.json, binding.clyoContainerView)
    }
}

