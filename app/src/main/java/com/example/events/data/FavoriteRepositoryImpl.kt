package com.example.events.data

import com.example.events.domain.entities.Favorite
import com.example.events.domain.repository.IFavoriteRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class FavoriteRepositoryImpl(private val apiInterface: ApiInterface): IFavoriteRepository {
    override suspend fun getFavoriteByUserId(userId: String): Favorite? {
        return apiInterface.getFavoritByUserId(userId)
    }
}