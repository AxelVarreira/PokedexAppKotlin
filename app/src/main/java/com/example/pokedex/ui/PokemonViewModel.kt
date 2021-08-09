package com.example.pokedex.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.model.PokemonModel
import com.example.pokedex.data.repository.PokemonRepository

class PokemonViewModel(val context: Context) : ViewModel() {
    private var pokemon = PokemonModel("Axl", "aloha.com.br")
    private var initialList = MutableLiveData<PokemonModel>()
    private val repositorio = PokemonRepository()

    private var _listaPokemons = MutableLiveData<PokemonModel>()
    val listaPokemons: LiveData<PokemonModel>
        get() = _listaPokemons

    init {
        initialList.postValue(pokemon)
        _listaPokemons = initialList
    }

    fun handleOnChange(){
        val listaPokemons = repositorio.getAllPokemons(context)

        for(Pokemon in listaPokemons){
            initialList.postValue(pokemon)
        }
    }

}