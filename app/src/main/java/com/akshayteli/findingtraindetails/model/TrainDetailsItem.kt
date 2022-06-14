package com.akshayteli.findingtraindetails.model


import com.google.gson.annotations.SerializedName

data class TrainDetailsItem(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("name")
    val name: String, // New Delhi - Howrah Rajdhani Express (via Patna)
    @SerializedName("train_from")
    val trainFrom: String, // NDLS
    @SerializedName("train_num")
    val trainNum: Int, // 12306
    @SerializedName("train_to")
    val trainTo: String // HWH
)