package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonListModel(
    val count: Int,
    @SerializedName("results") val results: List<PokemonModel>,
)
