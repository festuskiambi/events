package com.example.events.listevents.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.events.domain.entities.Event
import com.example.events.domain.entities.Favorite
import com.example.events.domain.usecases.event.EventUseCaseImpl
import com.example.events.domain.usecases.event.IEventUseCase
import com.example.events.domain.usecases.favorite.IFavoriteUseCase
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.launch

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventsViewModel(
    private val dispatchers: AppDispatchers,
    private val eventsUseCase: EventUseCaseImpl,
    private  val favororiteUseCase: IFavoriteUseCase

) : ViewModel() {

    private val eventListState = MutableLiveData<List<Event>>()
    val eventsList: LiveData<List<Event>> get() = eventListState

    private val favoriteState = MutableLiveData<Favorite>()
    val favorite: LiveData<Favorite> get() = favoriteState

    init {
        getEventsList()
        getFavoriteEventsList()
    }

    private fun getFavoriteEventsList()=  viewModelScope.launch(dispatchers.main) {
        val result = favororiteUseCase.getFavoriteByUserId("1")
        favoriteState.value = result
    }

    private fun getEventsList() = viewModelScope.launch(dispatchers.main) {
        val result = eventsUseCase.getEvents()
        eventListState.value = result
    }
}