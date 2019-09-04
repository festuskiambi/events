package com.example.events.domain.repository

import com.example.events.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface IEventRepository {

    suspend fun getEvents(): List<Event>?

    suspend fun getEventById(id: String): Event?
}