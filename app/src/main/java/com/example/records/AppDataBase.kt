package com.example.records

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MasterTable::class,SubTable::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun appDao(): AppDao
}