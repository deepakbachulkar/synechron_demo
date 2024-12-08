package com.demo.synetest.data.repository

import com.demo.synetest.data.api.ApiService
import com.demo.synetest.data.model.ItemDetailsResponse
import com.demo.synetest.data.model.ListResponse
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getListItems(): ListResponse{
        return apiService.getListItems()
    }

    suspend fun getDetailsItems(dbn:String): ItemDetailsResponse {
        return apiService.getDetailsItem(dbn)
    }
}