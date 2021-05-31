package com.krisnachy.retrofit.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.krisnachy.retrofit.R
import com.krisnachy.retrofit.model.ResultItem
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(var listPokemon: List<ResultItem?>?, var context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private lateinit var imgPokemon: ArrayList<String?>

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPokemon = itemView.iv_pokemon
        val namePokemon = itemView.tv_pokemon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var image = listPokemon?.get(position)
        Glide.with(context)
                .load(getImageUrl(image?.url!!)).into(holder.imgPokemon)
        holder.namePokemon.text = listPokemon?.get(position)?.name
    }

    override fun getItemCount(): Int = listPokemon?.size!!

    fun getImageUrl(url: String) : String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}