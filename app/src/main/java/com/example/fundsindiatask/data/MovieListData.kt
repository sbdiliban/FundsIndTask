package com.example.fundsindiatask.data

import com.google.gson.annotations.SerializedName

data class MovieListData( @SerializedName("score" ) var score : Double? = null,
                          @SerializedName("show"  ) var show  : Show?   = Show()) {
}