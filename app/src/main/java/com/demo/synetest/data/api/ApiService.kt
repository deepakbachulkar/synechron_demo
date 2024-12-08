package com.demo.synetest.data.api

import com.demo.synetest.data.model.ItemDetailsResponse
import com.demo.synetest.data.model.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    //https://data.cityofnewyork.us/resource/s3k6-pzi2.json
//    https://data.cityofnewyork.us/resource/f9bf-2cp4.json

//    https://data.cityofnewyork.us/resource/f9bf-2cp4.json
    @GET("/resource/f9bf-2cp4.json")
    suspend fun getListItems(): ListResponse

    //https://data.cityofnewyork.us/resource/f9bf-2cp4.json?dbn=11X253
    @GET("/resource/f9bf-2cp4.json")
    suspend fun getDetailsItem(@Query("dbn")dbn:String): ItemDetailsResponse
}