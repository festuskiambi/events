package com.example.events.domain.usecases.favorite

import com.example.events.domain.entities.Favorite

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface IFavoriteUseCase {

    suspend fun getFavorites(): List<Favorite>
}