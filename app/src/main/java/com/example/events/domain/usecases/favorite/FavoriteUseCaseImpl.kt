package com.example.events.domain.usecases.favorite

import com.example.events.domain.entities.Favorite
import com.example.events.domain.repository.IFavoriteRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class FavoriteUseCaseImpl(private val favoriteRepository: IFavoriteRepository): IFavoriteUseCase {
    override suspend fun getFavorites(): List<Favorite>? {

        return favoriteRepository.getFavorites()
    }
}