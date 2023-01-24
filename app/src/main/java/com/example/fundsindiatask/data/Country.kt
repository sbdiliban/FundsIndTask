package com.example.fundsindiatask.data

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name"     ) var name     : String? = null,
    @SerializedName("code"     ) var code     : String? = null,
    @SerializedName("timezone" ) var timezone : String? = null)
