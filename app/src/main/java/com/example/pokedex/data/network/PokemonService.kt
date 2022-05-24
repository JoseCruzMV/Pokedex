package com.example.pokedex.data.network


import com.example.pokedex.data.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService(
    private val api: PokemonApiClient

) {
    suspend fun getPokemonList(): List<PokemonModel> = withContext(Dispatchers.IO) {
        val response = api.getPokemonList()
        response.body()?.results ?: emptyList()
    }
}