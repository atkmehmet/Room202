package com.example.records

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

        @Insert
        suspend fun insertMaster(master: MasterTable)

        @Insert
        suspend fun insertSub(sub: SubTable)

        @Query("SELECT * FROM MasterTable")
        suspend fun getAllMasters(): List<MasterTable>

        @Query("SELECT * FROM SubTable WHERE masterId = :masterId")
        suspend fun getSubsByMasterId(masterId: Int): List<SubTable>


}