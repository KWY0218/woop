package com.example.woop.ui.read

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.woop.R
import com.example.woop.databinding.FragmentReadBottomSeatBinding
import com.example.woop.ui.base.BaseBottomSheetDialogFragment

class ReadBottomSeatFragment : BaseBottomSheetDialogFragment<FragmentReadBottomSeatBinding>(R.layout.fragment_read_bottom_seat) {
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

    override fun setBackground(drawable: ColorDrawable) {
        super.setBackground(drawable)
    }
}