package com.akshayteli.findingtraindetails.retrofit

import com.akshayteli.findingtraindetails.model.Request
import com.akshayteli.findingtraindetails.model.TrainDetails
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Akshay Teli on 10,June,2022
 */
interface RetrofitService {

    @Headers(
        *arrayOf(
            "content-type: application/json",
            "X-RapidAPI-Key: e28dda99f3msh2fe42c6fa014439p1cbdcajsncae53b8b9a73",
            "X-RapidAPI-Host: trains.p.rapidapi.com"
        ))
    @POST("https://trains.p.rapidapi.com/")
     suspend fun getDataFromAPI(@Body request: Request): TrainDetails
}

