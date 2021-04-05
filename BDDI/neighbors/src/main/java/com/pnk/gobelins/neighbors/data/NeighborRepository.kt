package com.pnk.gobelins.neighbors.data

import androidx.lifecycle.LiveData
import com.pnk.gobelins.neighbors.data.service.DummyNeighborApiService
import com.pnk.gobelins.neighbors.data.service.NeighborApiService
import com.pnk.gobelins.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService
    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): LiveData<List<Neighbor>> = apiService.neighbours

    fun createNeighbor(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    fun deleteNeighbor(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

    fun updateFavoriteStatus(neighbor: Neighbor) = apiService.updateFavoriteStatus(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
