package com.example.woop.ui.write

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.woop.R
import com.example.woop.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private val viewModel: WriteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityWriteBinding?>(this, R.layout.activity_write)
                .apply {
                    vm = viewModel
                    lifecycleOwner = this@WriteActivity
                }

        binding.writeFoodCp.setOnClickListener {
            binding.writeFoodCp.isSelected = true
            binding.writeFriendCp.isSelected = false
            binding.writeRequestCp.isSelected = false
        }

        binding.writeFriendCp.setOnClickListener {
            binding.writeFoodCp.isSelected = false
            binding.writeFriendCp.isSelected = true
            binding.writeRequestCp.isSelected = false
        }

        binding.writeRequestCp.setOnClickListener {
            binding.writeFoodCp.isSelected = false
            binding.writeFriendCp.isSelected = false
            binding.writeRequestCp.isSelected = true
        }
    }
}
