package com.example.pokedex.data.network

import com.example.pokedex.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiClient {
    @GET("pokemon?limit=20")
    suspend fun getPokemonList(): Response<PokemonListModel>
}