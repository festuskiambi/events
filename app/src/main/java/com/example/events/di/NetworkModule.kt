package com.example.events.di

import com.example.events.data.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Festus Kiambi on 9/4/19.
 */

val networkModule = module {

    factory { OkHttpClient.Builder().build() }

    factory { Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build() }

    single {
        Retrofit.Builder()
            .baseUrl("https://5d6cd581b20a2b00140d83d0.mockapi.io/api/v1/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    factory { get<Retrofit>().create(ApiInterface::class.java) }
}







