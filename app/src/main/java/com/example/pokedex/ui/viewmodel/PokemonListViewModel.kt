package com.example.pokedex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.domain.GetPokemonListUseCase
import kotlinx.coroutines.launch
import kotlin.text.Typography.quote

class PokemonListViewModel: ViewModel() {
    val pokemonList = MutableLiveData<List<PokemonModel>>()
    val getPokemonList = GetPokemonListUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getPokemonList()

            if (!result.isNullOrEmpty()) {
                pokemonList.postValue(result)
            }
        }
    }
}