package com.example.events.di

import com.example.events.data.EventRepositoryImpl
import com.example.events.domain.repository.IEventRepository
import com.example.events.domain.usecases.event.EventUseCaseImpl
import com.example.events.domain.usecases.event.IEventUseCase
import com.example.events.listevents.viewmodel.EventsViewModel
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/4/19.
 */

val eventModule = module {

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    factory { EventRepositoryImpl(get()) }

    factory { EventUseCaseImpl(get() ) }

    viewModel { EventsViewModel(get(), get(), get(), get()) }

}