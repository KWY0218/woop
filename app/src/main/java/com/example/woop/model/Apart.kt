package com.example.woop.model

data class Apart(
    val building_name: String,
    val building_floor: Int,
    val building_room_number: Int,
    val user_floor: Int,
    val user_room_number: Int,
    val room_exit: List<Boolean>? = null,
)
