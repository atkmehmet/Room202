package com.example.records

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.Dao
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SubtableView @Inject constructor(private val dao: Dao) :ViewModel() {

    var masterId by mutableStateOf("")
    private set

    var text by  mutableStateOf("")

    private val _subTables = MutableStateFlow<List<SubTable>>(emptyList())
    val subTables : StateFlow<List<SubTable>> = _subTables
    
}