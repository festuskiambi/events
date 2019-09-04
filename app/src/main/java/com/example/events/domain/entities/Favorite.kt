package com.example.events.domain.entities

import com.squareup.moshi.Json

data class Favorite(

    @Json(name = "createdAt")
    val createdAt: String? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "userId")
    val userId: String? = null,

    @Json(name = "events")
    val events: List<Event?>? = null
)