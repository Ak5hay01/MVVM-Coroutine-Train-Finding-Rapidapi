package com.akshayteli.findingtraindetails.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Akshay Teli on 10,June,2022
 */
class RetrofitInstance {
    companion object {
        val baseURL = "https://trains.p.rapidapi.com/"
        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}