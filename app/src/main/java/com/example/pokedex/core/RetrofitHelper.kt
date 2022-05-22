package com.example.pokedex.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val url = "https://pokeapi.co/api/v2/"

object RetrofitHelper {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}