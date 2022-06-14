package com.akshayteli.findingtraindetails.ui

import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshayteli.findingtraindetails.model.Request
import com.akshayteli.findingtraindetails.model.TrainDetails
import com.akshayteli.findingtraindetails.retrofit.RetrofitInstance
import com.akshayteli.findingtraindetails.retrofit.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var recyclerLstData: MutableLiveData<TrainDetails> = MutableLiveData()

    fun getListDataObserver(): MutableLiveData<TrainDetails> {
        return recyclerLstData
    }

    fun makeAPICall(input:String){
        val request = Request(input)

//  ----------------------------------------- WITHOUT COROUTINES     -------------------------------
       // val retrofitInstance = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
//        val call = retrofitInstance.getDataFromAPI(request)
//        call.enqueue(object:retrofit2.Callback<TrainDetails>{
//            override fun onResponse(call: Call<TrainDetails>, response: Response<TrainDetails>) {
//                if(response.isSuccessful){
//
//                    recyclerLstData.postValue(response.body())
//
//                }
//                else
//                {
//                    recyclerLstData.postValue(null)
//                }
//            }
//
//            override fun onFailure(call: Call<TrainDetails>, t: Throwable) {
////                Toast.makeText(this@MainActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
//                recyclerLstData.postValue(null)
//            }
//
//        })


//  -------------------------------      WITH COROUTINES
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitInstance = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
            val response = retrofitInstance.getDataFromAPI(request)
            Log.d("TAG", "makeAPICall: $response")
            recyclerLstData.postValue(response)
        }

    }



}
