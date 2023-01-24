package com.example.fundsindiatask.data

import com.google.gson.annotations.SerializedName

data class Externals(
    @SerializedName("tvrage"  ) var tvrage  : Int?    = null,
    @SerializedName("thetvdb" ) var thetvdb : Int?    = null,
    @SerializedName("imdb"    ) var imdb    : String? = null
)
