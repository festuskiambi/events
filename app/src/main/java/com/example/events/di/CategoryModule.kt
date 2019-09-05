package com.example.events.di

import com.example.events.data.CategoryRepositoryImpl
import com.example.events.domain.usecases.category.CategoryUseCaseImpl
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/5/19.
 */
val categoryModule = module {

    factory { CategoryRepositoryImpl(get ()) }

    factory {CategoryUseCaseImpl(get())}
}