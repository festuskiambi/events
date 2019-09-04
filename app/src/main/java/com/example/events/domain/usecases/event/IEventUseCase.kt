package com.example.events.domain.usecases.event

import com.example.events.domain.entities.Event

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface IEventUseCase {

    suspend fun getEvents(): List<Event>

    suspend fun getEventById(id: String): Event
}