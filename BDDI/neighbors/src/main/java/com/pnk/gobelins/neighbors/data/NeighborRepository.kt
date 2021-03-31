package com.pnk.gobelins.neighbors.data

import com.pnk.gobelins.neighbors.data.service.DummyNeighborApiService
import com.pnk.gobelins.neighbors.data.service.NeighborApiService
import com.pnk.gobelins.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService
    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun deleteNeighbor(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

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
