package com.demo.synetest.ui.screen.details_item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.synetest.data.model.Item
import com.demo.synetest.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsItemsViewModel @Inject constructor(private val repository: DataRepository):ViewModel() {

    val _itemsFlow = MutableStateFlow<List<Item>>(emptyList())

    fun getListItem(){
        viewModelScope.launch {
            _itemsFlow.value = repository.getListItems()
        }
    }
}