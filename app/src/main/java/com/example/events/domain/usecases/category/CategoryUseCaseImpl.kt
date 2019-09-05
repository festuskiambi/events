package com.example.events.domain.usecases.category

import com.example.events.data.CategoryRepositoryImpl
import com.example.events.domain.entities.Category

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class CategoryUseCaseImpl(private val categoryRepository: CategoryRepositoryImpl): ICategoryUseCase {
    override suspend fun getCategories(): List<Category>? {
        return categoryRepository.getCategories()
    }
}