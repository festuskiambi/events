package com.example.events.di

import com.example.events.domain.usecases.event.EventUseCaseImpl
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/4/19.
 */

val eventModule = module {

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    factory { EventUseCaseImpl(get())  }

}