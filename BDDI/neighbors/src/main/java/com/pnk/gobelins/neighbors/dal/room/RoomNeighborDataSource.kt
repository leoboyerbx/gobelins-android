package com.pnk.gobelins.neighbors.dal.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.pnk.gobelins.neighbors.dal.NeighborApiService
import com.pnk.gobelins.neighbors.dal.room.dao.NeighborDao
import com.pnk.gobelins.neighbors.dal.utilis.toEntity
import com.pnk.gobelins.neighbors.dal.utilis.toNeighbor
import com.pnk.gobelins.neighbors.models.Neighbor
import java.util.concurrent.Executors

class RoomNeighborDataSource(application: Application) : NeighborApiService {
    private val database: NeighborDataBase = NeighborDataBase.getDataBase(application)
    private val dao: NeighborDao = database.neighborDao()

    private val _neighbors = MediatorLiveData<List<Neighbor>>()

    init {
        _neighbors.addSource(dao.getNeighbors()) { entities ->
            _neighbors.value = entities.map { entity ->
                entity.toNeighbor()
            }
        }
    }

    override val neighbours: LiveData<List<Neighbor>>
        get() = _neighbors

    override fun deleteNeighbour(neighbor: Neighbor) {
        performAsync {
            dao.delete(neighbor.toEntity())
        }
    }

    override fun createNeighbour(neighbor: Neighbor) {
        performAsync {
            dao.add(neighbor.toEntity())
        }
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        neighbor.favorite = !neighbor.favorite
        performAsync {
            dao.update(neighbor.toEntity())
        }
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    private fun performAsync(action: (() -> Unit)) {
        Executors.newSingleThreadExecutor().execute {
            action.invoke()
        }
    }
}
