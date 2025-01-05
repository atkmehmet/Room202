package com.example.records

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubtableView @Inject constructor(private val dao: AppDao) :ViewModel() {

    var masterId by mutableStateOf("")
    private set

    var text by  mutableStateOf("")

    private val _subTables = MutableStateFlow<List<SubTable>>(emptyList())
    val subTables : StateFlow<List<SubTable>> = _subTables

    init {

    }

    fun updateMasterId(newMasterId:String){
        masterId = newMasterId
    }

    fun updateText(newText:String){
        text = newText
    }
    fun loadSubTable(){
        viewModelScope.launch {
            _subTables.value = dao.getSubsByMasterId(masterId = masterId.toInt())
        }
    }
}