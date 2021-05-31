package com.krisnachy.retrofit.presenter

import com.krisnachy.retrofit.model.ResponsePokemonData

interface MainPresenterPokemonBindView {
    fun onSuccess(data: ResponsePokemonData?)
    fun onError(msg: String)
}