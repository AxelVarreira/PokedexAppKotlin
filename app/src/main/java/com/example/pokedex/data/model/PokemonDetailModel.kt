package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("abilities")
    val abilities: List<String>,

    @SerializedName("baseExperience")
    val baseExperience: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("order")
    val order: Int,
)