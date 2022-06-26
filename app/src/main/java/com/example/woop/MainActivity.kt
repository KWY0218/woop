package com.example.woop

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.woop.databinding.ActivityMainBinding
import com.example.woop.model.MainGlass
import com.example.woop.ui.ClickDialog
import com.example.woop.ui.GlassActivity
import com.example.woop.ui.base.BaseActivity
import com.example.woop.ui.item.WallItem
import com.example.woop.ui.posts.PostListActivity
import com.example.woop.ui.write.WriteActivity
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    @Inject
    lateinit var apiService: ApiService

    var isFab = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnView()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.ivMorning.setOnClickListener {
            val fadeOut = ObjectAnimator.ofFloat(binding.ivMorning, "alpha", 1f, 0f)
            fadeOut.duration = 1500
            fadeOut.start()

            val fadeOut2 = ObjectAnimator.ofFloat(binding.ivSun, "alpha", 1f, 0f)
            fadeOut2.duration = 1500
            fadeOut2.start()
        }

        binding.fabMain.setOnClickListener {
            isFab = !isFab
            if (isFab) {
                binding.llFab.visibility = View.VISIBLE
                val fadeOut3 = ObjectAnimator.ofFloat(binding.llFab, "alpha", 0f, 1f)
                fadeOut3.duration = 500
                fadeOut3.start()
                ObjectAnimator.ofFloat(binding.llFab, "translationY", -200f).apply { start() }
            } else {
                val fadeOut3 = ObjectAnimator.ofFloat(binding.llFab, "alpha", 1f, 0f)
                fadeOut3.duration = 500
                fadeOut3.start()
                ObjectAnimator.ofFloat(binding.llFab, "translationY", 0f).apply { start() }
                binding.llFab.visibility = View.INVISIBLE
            }
        }
        binding.btnCock.setOnClickListener {
            ClickDialog().show(this.supportFragmentManager.beginTransaction(), "logout")
        }

        binding.btnWrite.setOnClickListener {
            startActivity(Intent(this@MainActivity, WriteActivity::class.java))
        }

        binding.rvBuilding.setOnClickListener {
            startActivity(Intent(this@MainActivity, GlassActivity::class.java))
        }

        binding.mainBt.setOnClickListener {
            startActivity(Intent(this, PostListActivity::class.java))
        }
    }

    private fun setOnView() {
        lifecycleScope.launch {
            runCatching { apiService.getApart(1) }
                .onSuccess { apart ->
                    Log.d("aprart", "sadfasdf")
                    binding.include.tvTitle.text = apart.response.building_name
                    binding.include.tvTitle.visibility = View.VISIBLE
                    var groupAdapter = GroupieAdapter()
                    val buildingSection = Section()

                    repeat(apart.response.building_floor) { floor ->
                        repeat(4) { roomNumber ->
                            if (floor == apart.response.user_floor - 1 && roomNumber == apart.response.user_room_number - 1) buildingSection.add(
                                WallItem(MainGlass(isMe = true))
                            )
                            else buildingSection.add(WallItem())
                        }
                    }
                    groupAdapter.add(buildingSection)
                    binding.rvBuilding.adapter = groupAdapter
                    val staggeredGridLayoutManager =
                        StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
                    staggeredGridLayoutManager.reverseLayout = true
                    binding.rvBuilding.layoutManager = staggeredGridLayoutManager

                    groupAdapter.spanSizeLookup
                }
                .onFailure {
                    Log.d("asdf", "post fail: ${it.message} error: $it")
                }
        }
    }
}
