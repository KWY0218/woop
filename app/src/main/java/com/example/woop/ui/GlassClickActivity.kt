package com.example.woop.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.woop.ApiService
import com.example.woop.R
import com.example.woop.databinding.ActivityClickGlassBinding
import com.example.woop.model.Apart
import com.example.woop.ui.base.BaseActivity
import com.example.woop.ui.item.GlassExpandItem
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class GlassClickActivity : BaseActivity<ActivityClickGlassBinding>(R.layout.activity_click_glass) {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnView()
    }

    private fun setOnView() {
        val apart = Apart(
            building_name = "서울 광역시 진달래 아파트 403동",
            building_floor = 15,
            building_room_number = 8,
            user_floor = 14,
            user_room_number = 3
        )
        binding.include2.tvTitle.text = "201동 7층"
        binding.include2.tvTitle.visibility = View.VISIBLE

        var groupAdapter = GroupieAdapter()
        val buildingSection = Section()

        repeat(apart.building_room_number) { roomNumber ->
            if (roomNumber == apart.user_room_number - 1) buildingSection.add(
                GlassExpandItem(
                    isMine = true,
                    roomNumber = "${apart.building_floor}0${roomNumber}호"
                )
            )
            else buildingSection.add(
                GlassExpandItem(
                    roomNumber = "${apart.building_floor}0${roomNumber}호",
                    isClick = true
                )
            )
        }
        groupAdapter.add(buildingSection)
        binding.rvRoom.adapter = groupAdapter
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
        staggeredGridLayoutManager.reverseLayout = true
        binding.rvRoom.layoutManager = staggeredGridLayoutManager
        groupAdapter.spanSizeLookup

        binding.ivCock.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                runCatching {
                    apiService.qooq(103, 803, 2)
                }.onSuccess {
                    Timber.d(" 보낸다")
                }.onFailure {
                    Timber.d(" 못 보낸다")
                }
            }
            CockDialog().show(this.supportFragmentManager.beginTransaction(), "logout")
        }
    }
}
