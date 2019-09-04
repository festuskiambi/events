package com.example.events.domain.usecases.category

import com.example.events.domain.entities.Category
import com.example.events.domain.repository.ICategoryRepository

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class CategoryUseCaseImpl(private val categoryRepository: ICategoryRepository): ICategoryUseCase {
    override suspend fun getCategories(): List<Category>? {
        return categoryRepository.getCategories()
    }
}