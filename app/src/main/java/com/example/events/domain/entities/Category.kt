package com.example.events.domain.entities

import com.squareup.moshi.Json

data class Category(

	@Json(name="createdAt")
	val createdAt: String? = null,

	@Json(name="imageUrl")
	val imageUrl: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="title")
	val title: String? = null
)