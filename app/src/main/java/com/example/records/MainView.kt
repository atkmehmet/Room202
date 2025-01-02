package com.example.records

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainView @Inject constructor(private val dao: AppDao):ViewModel() {

    init {
        viewModelScope.launch {
            dao.insertMaster(MasterTable(1,"xx","xx Explain"))
        }
    }

}