package com.example.studymatchingapp.ui.base

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.example.woop.ui.GlassClickActivity

abstract class BaseDialogFragment<B : ViewDataBinding>(private val layoutId: Int) :
    DialogFragment() {
    lateinit var binding: B
    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        binding.root.setOnClickListener {
            startActivity(Intent(binding.root.context, GlassClickActivity::class.java))
        }
        return binding.root
    }

    open fun setCancel(setting: Boolean) {
        isCancelable = setting
    }

//    open fun setWindowFeature(feature: Int) {
//        activity.requestWindowFeature(feature)
//    }

    open fun setBackground() {
    }
}
