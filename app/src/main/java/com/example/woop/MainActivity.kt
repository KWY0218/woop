package com.example.woop

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.woop.databinding.ActivityMainBinding
import com.example.woop.model.Apart
import com.example.woop.model.MainGlass
import com.example.woop.ui.base.BaseActivity
import com.example.woop.ui.item.WallItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

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
//            ObjectAnimator.ofFloat(binding.llFab, "translationY", -0f).apply { start() }
        }
    }

    private fun setOnView() {
        val apart = Apart(
            building_name = "서울 광역시 진달래 아파트 403호",
            building_floor = 15,
            building_room_number = 8,
            user_floor = 14,
            user_room_number = 3
        )
        binding.include.tvTitle.text = apart.building_name

        var groupAdapter = GroupieAdapter()
        val buildingSection = Section()

        repeat(apart.building_floor) { floor ->
            repeat(4) { roomNumber ->
                if (floor == apart.user_floor - 1 && roomNumber == apart.user_room_number - 1) buildingSection.add(
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
}
