package com.example.woop

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
        setOnClickListener()
    }

    private fun setOnClickListener() {
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

        val floor = 15
        repeat(floor) {
            repeat(4) {
                buildingSection.add(WallItem())
                repeat(apart.building_floor) { floor ->
                    repeat(4) { roomNumber ->
                        if (floor == apart.user_floor - 1 && roomNumber == apart.user_room_number - 1) buildingSection.add(
                            WallItem(MainGlass(isMe = true))
                        )
                        else buildingSection.add(WallItem())
                    }
                }

                binding.rvBuilding.adapter = groupAdapter
                val staggeredGridLayoutManager =
                    StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
                staggeredGridLayoutManager.reverseLayout = true
                binding.rvBuilding.layoutManager = staggeredGridLayoutManager

                groupAdapter.spanSizeLookup
            }
        }
    }
}
