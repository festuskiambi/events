package com.example.events.domain.usecases.favorite

import com.example.events.data.FavoriteRepositoryImpl
import com.example.events.domain.entities.Favorite

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class FavoriteUseCaseImpl(private val favoriteRepository: FavoriteRepositoryImpl) : IFavoriteUseCase {
    override suspend fun getFavoriteByUserId(userId: String): Favorite? {
        return favoriteRepository.getFavoriteByUserId(userId)
    }
}