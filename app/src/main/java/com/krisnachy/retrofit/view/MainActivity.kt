package com.krisnachy.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.krisnachy.retrofit.R
import com.krisnachy.retrofit.model.ResponsePokemonData
import com.krisnachy.retrofit.presenter.MainPresenterPokemon
import com.krisnachy.retrofit.presenter.MainPresenterPokemonBindView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenterPokemonBindView {
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var mainPresenterPokemon: MainPresenterPokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupComponent()
    }

    private fun setupComponent() {
        mainPresenterPokemon = MainPresenterPokemon(this@MainActivity)
        mainPresenterPokemon.getDataPokemon()
    }

    override fun onSuccess(data: ResponsePokemonData?) {
        Log.d("result", data?.results.toString())
        pokemonAdapter = PokemonAdapter(data?.results, this@MainActivity)
        rv_pokemon.apply {
            rv_pokemon.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rv_pokemon.setHasFixedSize(true)
            rv_pokemon.adapter = pokemonAdapter
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}