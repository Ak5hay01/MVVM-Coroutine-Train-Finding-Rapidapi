package com.akshayteli.findingtraindetails.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("arriveTime")
    val arriveTime: String, // 12:15 +1 night
    @SerializedName("classes")
    val classes: List<String>,
    @SerializedName("days")
    val days: Days,
    @SerializedName("departTime")
    val departTime: String, // 16:55
    @SerializedName("from_id")
    val fromId: String, // 664
    @SerializedName("id")
    val id: String, // 1319
    @SerializedName("to_id")
    val toId: String // 1
)