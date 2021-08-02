package com.example.pokedex.data.repository

import com.example.pokedex.data.model.PokemonDetailModel
import com.example.pokedex.data.model.PokemonModel
import retrofit2.Response

class PokemonRepository {

    fun getAllPokemons(): Response<PokemonModel> {
        TODO("Not yet implemented")
    }

    fun getDetailedPokemon(nomePokemon: String): Response<PokemonDetailModel> {
        TODO("Not yet implemented")
    }
}