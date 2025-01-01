package com.example.records

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MasterTable")
class MasterTable
    (
 @PrimaryKey @ColumnInfo(name = "id") val id: Long,
         @ColumnInfo(name = "name") val name: String,
         @ColumnInfo(name = "text") val text: String
)