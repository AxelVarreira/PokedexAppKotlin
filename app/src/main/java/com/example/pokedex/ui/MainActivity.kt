package com.example.pokedex.ui

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.R
import com.example.pokedex.data.repository.PokemonRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val pokemonRepository = PokemonRepository()

        pokemonRepository.getAllPokemons(baseContext, button)
    }
}