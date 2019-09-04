package com.example.events.data

import com.example.events.domain.entities.Event
import com.example.events.domain.repository.IEventRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventRepositoryImpl(private val apiInterface: ApiInterface) : IEventRepository {
    override suspend fun getEvents(): List<Event>? {
        return apiInterface.getEvents().body()
    }

    override suspend fun getEventById(id: String): Event? {
        return apiInterface.getEventById(id).body()
    }
}