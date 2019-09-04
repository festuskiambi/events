package com.example.events.domain.entities

import com.squareup.moshi.Json
import java.util.*

data class TicketType(

    @Json(name = "closeDate")
    val closeDate: Date? = null,

    @Json(name = "createdAt")
    val createdAt: String? = null,

    @Json(name = "price")
    val price: Double? = null,

    @Json(name = "closeTime")
    val closeTime: String? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "title")
    val title: String? = null
)