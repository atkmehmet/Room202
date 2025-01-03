package com.example.records

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainView @Inject constructor(private val dao: AppDao):ViewModel() {
    private val _masters = MutableStateFlow<List<MasterTable>>(emptyList())
    val masters: StateFlow<List<MasterTable>> = _masters
    init {
        viewModelScope.launch {
            dao.insertMaster(MasterTable(2,"xx","xx Explain"))
            _masters.value = dao.getAllMasters() // Example query
        }
    }

}