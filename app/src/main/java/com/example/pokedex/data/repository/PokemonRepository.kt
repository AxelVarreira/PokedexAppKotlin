package com.example.pokedex.data.repository

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.pokedex.R
import com.example.pokedex.data.model.PokemonApiResponse
import com.example.pokedex.data.model.PokemonDetailModel
import com.example.pokedex.data.remote.PokeApiService
import com.example.pokedex.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    fun getAllPokemons(baseContext: Context, button: Button) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(PokeApiService::class.java)
        val callback = endpoint.getAllPokemons()

        callback.enqueue(object : Callback<PokemonApiResponse> {
            override fun onFailure(call: Call<PokemonApiResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PokemonApiResponse>, response: Response<PokemonApiResponse>) {
                response.body()?.results?.forEach {
                    button.text = button.text.toString().plus(it.name)
                }
            }
        })
    }

    fun getDetailedPokemon(nomePokemon: String): Response<PokemonDetailModel> {
        TODO("Not yet implemented")
    }
}