package com.example.pokedex.data.network

import com.example.pokedex.core.RetrofitHelper
import com.example.pokedex.data.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemonList(): List<PokemonModel> = withContext(Dispatchers.IO) {
        val response = retrofit.create(PokemonApiClient::class.java).getPokemonList()
        response.body()?.results ?: emptyList()
    }
}