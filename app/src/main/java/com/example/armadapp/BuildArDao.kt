package com.example.armadapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BuildArDao {

    @Query("SELECT * FROM build_ar_table")
    fun getAllBuildAr(): Flow<List<BuildAr>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(buildAr: BuildAr)

    @Query("DELETE FROM build_ar_table")
    suspend fun deleteAll()
}
