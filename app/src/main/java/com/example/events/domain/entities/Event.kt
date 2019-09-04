package com.example.events.domain.entities

import com.squareup.moshi.Json
import java.util.*

data class Event(

    @Json(name = "date")
    val date: Date? = null,

    @Json(name = "createdAt")
    val createdAt: String? = null,

    @Json(name = "featured")
    val featured: Boolean? = null,

    @Json(name = "imageUrl")
    val imageUrl: String? = null,

    @Json(name = "tickectTypes")
    val ticketTypes: List<TicketType?>? = null,

    @Json(name = "host")
    val host: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "location")
    val location: String? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "categoryId")
    val categoryId: String? = null
)