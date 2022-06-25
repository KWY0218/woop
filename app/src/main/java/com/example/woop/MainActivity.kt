package com.example.woop

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.woop.ui.base.BaseActivity
import com.example.woop.databinding.ActivityMainBinding
import com.example.woop.ui.item.WallItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnView()
    }

    private fun setOnView() {
        var groupAdapter = GroupieAdapter()
        val buildingSection = Section()

        val floor = 15
        repeat(floor) {
            repeat(4) {
                buildingSection.add(WallItem())
            }
        }

        groupAdapter.add(buildingSection)

        binding.rvBuilding.adapter = groupAdapter
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
        binding.rvBuilding.layoutManager = staggeredGridLayoutManager

        groupAdapter.spanSizeLookup
    }
}
