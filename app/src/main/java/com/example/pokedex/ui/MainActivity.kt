package com.example.pokedex.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.R
import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.data.remote.PokeApiService
import com.example.pokedex.utils.Constants
import com.example.pokedex.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val textView: TextView = findViewById<TextView>(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(PokeApiService::class.java)
        val callback = endpoint.getAllPokemons()

        callback.enqueue(object : Callback<List<PokemonModel>> {
            override fun onFailure(call: Call<List<PokemonModel>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<PokemonModel>>, response: Response<List<PokemonModel>>) {
                response.body()?.forEach {
                   val textView = textView.text.toString().plus(it.name)
                }
            }
        })

    }
}