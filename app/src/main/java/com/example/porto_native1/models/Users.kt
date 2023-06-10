package com.example.porto_native1.models

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)