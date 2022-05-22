package com.example.pokedex.domain

import com.example.pokedex.data.PokemonRepository
import com.example.pokedex.data.model.PokemonModel

class GetPokemonListUseCase {
    private val repository = PokemonRepository()

    suspend operator fun invoke(): List<PokemonModel> = repository.getPokemonList()
}