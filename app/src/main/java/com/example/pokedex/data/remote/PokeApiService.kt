package com.example.pokedex.data.remote

import com.example.pokedex.data.model.PokemonDetailModel
import com.example.pokedex.data.model.PokemonModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    @GET("pokemon")
     fun getAllPokemons() : Call<List<PokemonModel>>

    @GET("pokemon/{nomePokemon}")
     fun getDetailedPokemon(
        @Path("nomePokemon") nomePokemon: String,
    ) : Call<List<PokemonDetailModel>>
}