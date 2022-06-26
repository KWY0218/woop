package com.example.woop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studymatchingapp.ui.base.BaseDialogFragment
import com.example.woop.R
import com.example.woop.databinding.FragmentCockDialogBinding

class CockDialog : BaseDialogFragment<FragmentCockDialogBinding>(R.layout.fragment_cock_dialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setWindowFeature() {
    }
}
