package com.example.woop.ui.write

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.woop.ApiService
import com.example.woop.R
import com.example.woop.databinding.ActivityWriteBinding
import com.example.woop.request.WriteRequest
import com.example.woop.ui.posts.PostListActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding

    @Inject
    lateinit var apiService: ApiService
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

        binding.writeSendBtn.setOnClickListener {
            lifecycleScope.launch {
                runCatching {
                    val writeRequest = WriteRequest(
                        binding.writeTitleEt.text.toString(),
                        binding.writeContentEt.text.toString(),
                        getInt()
                    )
                    delay(100)
                    apiService.writePost(writeRequest)
                }
                    .onSuccess {
                        Log.d("asdf", "success")
                    }
                    .onFailure { Log.d("asdf", "fail") }
            }
            startActivity(Intent(this, PostListActivity::class.java))
        }
    }

    private fun getInt(): Int {
        if (binding.writeFoodCp.isSelected) return 1
        if (binding.writeFriendCp.isSelected) return 2
        if (binding.writeRequestCp.isSelected) return 3
        return 1
    }
}
