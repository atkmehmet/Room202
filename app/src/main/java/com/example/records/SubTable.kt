package com.example.records

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SubTable")
 class SubTable(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
     @ColumnInfo(name = "masterId") val masterId: Long,
     @ColumnInfo(name = "text") val text:String
 )
