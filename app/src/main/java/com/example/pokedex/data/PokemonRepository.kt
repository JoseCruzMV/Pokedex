package com.example.pokedex.data

import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.data.network.PokemonService

class PokemonRepository(
    private val api: PokemonService
) {
    suspend fun getPokemonList(): List<PokemonModel> = api.getPokemonList()
}