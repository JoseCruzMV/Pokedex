package com.example.pokedex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.domain.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    val pokemonList = MutableLiveData<List<PokemonModel>>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getPokemonListUseCase()

            if (!result.isNullOrEmpty()) {
                pokemonList.postValue(result)
            }
        }
    }
}