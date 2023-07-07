package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.eliascoelho911.clyo.sample.R
import com.eliascoelho911.clyo.sample.databinding.ActivityClyoSampleBinding

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoContainerView)
        ActivityClyoSampleBinding.bind(root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}