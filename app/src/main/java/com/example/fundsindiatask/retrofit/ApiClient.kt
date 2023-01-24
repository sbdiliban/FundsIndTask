package com.example.fundsindiatask.retrofit

import com.example.fundsindiatask.data.MovieListData
import retrofit2.http.GET

interface ApiClient {
    @GET("shows/?q=friends")
    suspend fun getMovieList(): retrofit2.Response<ArrayList<MovieListData>>
}