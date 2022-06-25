package com.example.woop.request

data class WriteRequest(
    val title: String,
    val content: String,
    val tag: Int
)
