package com.example.pokedex.ui

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.data.repository.PokemonRepository

import android.widget.ArrayAdapter
import com.example.pokedex.R


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        val pokemonRepository = PokemonRepository()
        val listaDePokemons = pokemonRepository.getAllPokemons(baseContext)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frutas = ArrayList<String>()

        if (listaDePokemons != null) {
            for(pokemons in listaDePokemons){
                frutas.add(pokemons.name)
            }
        }

        listView = findViewById(R.id.button_list_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, frutas)
        listView.adapter = adapter
    }
}