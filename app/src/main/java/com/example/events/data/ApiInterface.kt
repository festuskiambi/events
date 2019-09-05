package com.example.events.data

import com.example.events.domain.entities.Category
import com.example.events.domain.entities.Event
import com.example.events.domain.entities.Favorite
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface ApiInterface {

    @GET("events")
    suspend fun getEvents(): Response<List<Event>>

    @GET("events/{id}")
    suspend fun getEventById(@Path("id") id: String): Response<Event>

    @GET("favovites/{id}")
    suspend fun getFavoritByUserId(@Path("id") id: String): Favorite

    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>
}