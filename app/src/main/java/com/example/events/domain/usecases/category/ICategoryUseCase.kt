package com.example.events.domain.usecases.category

import com.example.events.domain.entities.Category

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface ICategoryUseCase {

    suspend fun getCategories(): List<Category>

}