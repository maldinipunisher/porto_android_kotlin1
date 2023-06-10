package com.example.porto_native1.models

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val text: String,
    val url: String
)