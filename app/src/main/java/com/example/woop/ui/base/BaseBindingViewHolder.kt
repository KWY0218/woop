package com.example.studymatchingapp.ui.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<out T : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
    val binding: T? = DataBindingUtil.bind(view)

    init {
        onCreate()
    }
    abstract fun onCreate()
    open fun onBind(position: Int){
        itemView.tag = position
    }
}