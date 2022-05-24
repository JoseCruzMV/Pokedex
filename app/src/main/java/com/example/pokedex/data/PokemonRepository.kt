package com.example.pokedex.data

import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.data.network.PokemonService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonService
) {
    suspend fun getPokemonList(): List<PokemonModel> = api.getPokemonList()
}