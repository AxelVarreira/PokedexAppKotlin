package com.example.pokedex.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.model.PokemonModel


class AdapterPokemon(private val context: Context, private val pokemons: MutableList<PokemonModel>): RecyclerView.Adapter<AdapterPokemon.PokemonViewHolder>(){

    inner class PokemonViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val button = itemView.findViewById<Button>(R.id.pokemon_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        // Cria as visualizacoes (item da lista)

        val itemLista = LayoutInflater.from(context).inflate(R.layout.pokemon, parent, false)

        return PokemonViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        // Exibi as visualizacoes (item da lista)
        holder.button.text = pokemons[position].name
    }

    // Passamos o tamanho da nossa lista
    override fun getItemCount(): Int  = pokemons.size
}