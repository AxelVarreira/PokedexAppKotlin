package com.example.pokedex.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object {


        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}