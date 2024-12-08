package com.demo.synetest.ui.screen.list_items.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.synetest.data.model.Item
import com.demo.synetest.data.model.ItemDetails
import com.demo.synetest.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListItemsViewModel @Inject constructor(private val repository: DataRepository):ViewModel() {

    val _itemsFlow = MutableStateFlow<List<Item>>(emptyList())

    val _itemDetailsFlow = MutableStateFlow<List<ItemDetails>>(emptyList())

    fun getListItem(){
        viewModelScope.launch {
            _itemsFlow.value = repository.getListItems()
        }
    }

    fun getDetailsItem(dbn:String){
        viewModelScope.launch {
            _itemDetailsFlow.value = repository.getDetailsItems(dbn)
        }
    }
}