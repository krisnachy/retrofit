package com.krisnachy.retrofit.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponsePokemonData(
    @field: SerializedName("next")
    val next: String? = null,

    @field: SerializedName("previous")
    val previous: String? = null,

    @field: SerializedName("count")
    val count: Int? = null,

    @field: SerializedName("results")
    val results: List<ResultItem?>? = null
) : Parcelable

@Parcelize
data class ResultItem(
    @field: SerializedName("name")
    val name: String? = null,

    @field: SerializedName("url")
    val url: String? = null
) : Parcelable

