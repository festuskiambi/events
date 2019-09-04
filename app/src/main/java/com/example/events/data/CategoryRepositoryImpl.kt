package com.example.events.data

import com.example.events.domain.entities.Category
import com.example.events.domain.repository.ICategoryRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class CategoryRepositoryImpl (private val apiInterface: ApiInterface): ICategoryRepository {
    override suspend fun getCategories(): List<Category> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}