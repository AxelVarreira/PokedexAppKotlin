package com.example.pokedex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.model.PokemonModel

class PokemonViewModel : ViewModel() {
    private var pokemon = PokemonModel("Axl", "aloha.com.br")
    private var initialList = MutableLiveData<PokemonModel>()

    private var _listaPokemons = MutableLiveData<PokemonModel>()
    val listaPokemons: LiveData<PokemonModel>
        get() = _listaPokemons


    init {
        initialList.postValue(pokemon)
        _listaPokemons = initialList
    }

    fun handleOnChange(listaPokemons: ArrayList<PokemonModel>){
        for(Pokemon in listaPokemons){
            initialList.postValue(pokemon)
        }
    }

}