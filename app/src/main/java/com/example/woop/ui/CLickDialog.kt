package com.example.woop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studymatchingapp.ui.base.BaseDialogFragment
import com.example.woop.R
import com.example.woop.databinding.FragmentDialogClickBinding

class CLickDialog : BaseDialogFragment<FragmentDialogClickBinding> (R.layout.fragment_dialog_click){

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

    override fun setCancel(setting: Boolean) {
        super.setCancel(setting)
    }

    override fun setWindowFeature(feature: Int) {
        super.setWindowFeature(feature)
    }

    override fun setBackground() {
        super.setBackground()
    }
}