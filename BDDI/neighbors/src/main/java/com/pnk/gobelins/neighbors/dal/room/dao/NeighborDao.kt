package com.pnk.gobelins.neighbors.dal.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pnk.gobelins.neighbors.dal.room.entities.NeighborEntity

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>
    @Insert
    fun add(vararg neighbors: NeighborEntity)
}
