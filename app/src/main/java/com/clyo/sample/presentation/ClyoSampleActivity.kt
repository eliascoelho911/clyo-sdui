package com.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.screen.newScreen
import com.clyo.android.scope.provider.clyo
import com.clyo.sample.R
import com.clyo.sample.databinding.ActivityClyoSampleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoPageHolderView)
        ActivityClyoSampleBinding.bind(root)
    }

    private val clyo by clyo()

    private val viewModel: ClyoSampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getPageJson().observe(this) { jsonValue ->
            val page = clyo.newScreen(jsonValue)
            binding.clyoPageHolderView.show(page)
        }
    }
}