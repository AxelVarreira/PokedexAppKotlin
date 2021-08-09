package com.example.pokedex.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewmodel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonRepository = PokemonRepository()

        val listaDePokemons = pokemonRepository.getAllPokemons(baseContext)

        val recyclerViewPokemons = findViewById<RecyclerView>(R.id.recyclerView_pokemon)

        // Seta view na vertical
        recyclerViewPokemons.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Da mais desempenho
        recyclerViewPokemons.setHasFixedSize(true)

        // Configuraocao do adapter
        val adapterPokemon = AdapterPokemon(this, listaDePokemons)
        recyclerViewPokemons.adapter = adapterPokemon

        // Binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
    }
}