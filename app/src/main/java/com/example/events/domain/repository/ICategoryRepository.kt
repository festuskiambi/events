package com.example.events.domain.repository

import com.example.events.domain.entities.Category

/**
 * Created by Festus Kiambi on 9/4/19.
 */
interface ICategoryRepository {

    suspend fun getCategories(): List<Category>
}