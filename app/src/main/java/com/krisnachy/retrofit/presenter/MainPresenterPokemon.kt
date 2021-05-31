package com.krisnachy.retrofit.presenter

import com.krisnachy.retrofit.model.ResponsePokemonData
import com.krisnachy.retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenterPokemon (private val mainPresenterPokemonBindView: MainPresenterPokemonBindView) {
    fun getDataPokemon() {
        ApiClient.instance.getData().enqueue(object : Callback<ResponsePokemonData> {
            override fun onResponse(
                call: Call<ResponsePokemonData>,
                response: Response<ResponsePokemonData>
            ) {
                if (response.isSuccessful) {
                    mainPresenterPokemonBindView.onSuccess(response.body())
                } else mainPresenterPokemonBindView.onError("No Data")
            }

            override fun onFailure(call: Call<ResponsePokemonData>, t: Throwable) {
                mainPresenterPokemonBindView.onError(t.localizedMessage)
            }
        })
    }
}

