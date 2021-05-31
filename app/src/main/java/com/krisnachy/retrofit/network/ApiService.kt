package com.krisnachy.retrofit.network

import com.krisnachy.retrofit.model.ResponsePokemonData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    fun getData(): Call<ResponsePokemonData>
}