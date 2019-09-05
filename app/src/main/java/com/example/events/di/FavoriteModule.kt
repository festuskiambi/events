package com.example.events.di

import com.example.events.data.FavoriteRepositoryImpl
import com.example.events.domain.repository.IFavoriteRepository
import com.example.events.domain.usecases.favorite.FavoriteUseCaseImpl
import com.example.events.domain.usecases.favorite.IFavoriteUseCase
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/4/19.
 */

val factoryModule = module {

    factory { FavoriteRepositoryImpl(get()) }

    factory { FavoriteUseCaseImpl(get()) }
}