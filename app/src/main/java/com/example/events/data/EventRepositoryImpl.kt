package com.example.events.data

import com.example.events.domain.entities.Event
import com.example.events.domain.repository.IEventRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventRepositoryImpl(private val apiInterface: ApiInterface) : IEventRepository {
    override suspend fun getEvents(): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getEventById(id: String): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}