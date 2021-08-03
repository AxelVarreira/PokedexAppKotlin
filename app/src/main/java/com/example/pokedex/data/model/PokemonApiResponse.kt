package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonApiResponse (

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: Int?,

    @SerializedName("results")
    val results: List<PokemonModel>
)

