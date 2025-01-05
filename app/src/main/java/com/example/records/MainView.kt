package com.example.records

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var name by mutableStateOf("")
     private set

    var text by mutableStateOf("")
    private set

 fun insertMaster() {
     viewModelScope.launch {
         dao.insertMaster(MasterTable(name = name, text = text))
         _masters.value = dao.getAllMasters() // Example query
     }
 }

    fun updateName(newName:String){
        name = newName
    }

     fun updateText(newText:String){
         text = newText
     }

 }

