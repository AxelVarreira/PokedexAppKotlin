package com.example.pokedex.data.remote

import com.example.pokedex.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeApiServiceInstance {
    companion object{
        private var instance: PokeApiServiceInstance? = null

        fun getInstance(): PokeApiServiceInstance{
            if (instance == null){
                instance = PokeApiServiceInstance()
            }

            return instance!!
        }
    }

    // var api: PokeApiService
    //get() {
    //    return retrofit.create(PokeApiService::class.java)
    //}

    private val retrofit: Retrofit

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(Constants.SERVICE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}