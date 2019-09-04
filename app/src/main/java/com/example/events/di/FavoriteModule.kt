package com.example.events.di

import com.example.events.domain.usecases.favorite.FavoriteUseCaseImpl
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/4/19.
 */

val factoryModule = module {

    factory { FavoriteUseCaseImpl(get()) }
}