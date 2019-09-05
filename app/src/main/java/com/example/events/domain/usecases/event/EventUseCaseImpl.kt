package com.example.events.domain.usecases.event

import com.example.events.data.EventRepositoryImpl
import com.example.events.domain.entities.Event
import com.example.events.domain.repository.IEventRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventUseCaseImpl(private val eventRepository: EventRepositoryImpl): IEventUseCase {
    override suspend fun getEvents(): List<Event>? {
        return eventRepository.getEvents()
    }

    override suspend fun getEventById(id: String): Event? {
        return eventRepository.getEventById(id)
    }
}