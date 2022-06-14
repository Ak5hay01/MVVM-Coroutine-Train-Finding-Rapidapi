package com.akshayteli.findingtraindetails.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class Days(
    @SerializedName("Fri")
    val fri: Object, // 1
    @SerializedName("Mon")
    val mon: Object, // 0
    @SerializedName("Sat")
    val sat: Object, // 0
    @SerializedName("Sun")
    val sun: Object, // 0
    @SerializedName("Thu")
    val thu: Object, // 0
    @SerializedName("Tue")
    val tue: Object, // 0
    @SerializedName("Wed")
    val wed: Object // 0
)