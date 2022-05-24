package com.example.pokedex.domain

import com.example.pokedex.data.PokemonRepository
import com.example.pokedex.data.model.PokemonModel
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {
    suspend operator fun invoke(): List<PokemonModel> = repository.getPokemonList()
}