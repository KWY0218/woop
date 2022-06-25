package com.example.woop.ui

import android.os.Bundle
import com.example.woop.R
import com.example.woop.databinding.ActivityGlassBinding
import com.example.woop.ui.base.BaseActivity

class GlassActivity : BaseActivity<ActivityGlassBinding>(R.layout.activity_glass) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListner()
        setOnView()
    }

    private fun setOnView() {

    }

    private fun setOnClickListner() {

    }
}
