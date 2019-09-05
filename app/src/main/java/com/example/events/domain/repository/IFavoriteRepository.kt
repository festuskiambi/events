package com.example.events.domain.repository

import com.example.events.domain.entities.Favorite

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface IFavoriteRepository {

    suspend fun getFavoriteByUserId(userId: String): Favorite?
}