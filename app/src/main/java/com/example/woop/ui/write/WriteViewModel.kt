package com.example.woop.ui.write

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WriteViewModel : ViewModel() {
    val title = MutableStateFlow("")
    val writer = MutableStateFlow("")
    val content = MutableStateFlow("")

    fun writePost() {
        viewModelScope.launch {
            Log.d("asdf", "write")
        }
    }
}
