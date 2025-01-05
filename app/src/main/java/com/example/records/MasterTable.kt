package com.example.records

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MasterTable")
class MasterTable
    (
 @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
         @ColumnInfo(name = "name") val name: String,
         @ColumnInfo(name = "text") val text: String
)