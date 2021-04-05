package com.pnk.gobelins.neighbors.data.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pnk.gobelins.neighbors.models.Neighbor

class DummyNeighborApiService : NeighborApiService {

    private val _neighbours = MutableLiveData<List<Neighbor>>()

    override val neighbours: LiveData<List<Neighbor>>
        get() = _neighbours

    init {
        _neighbours.value = DUMMY_NeighborS
    }

    override fun deleteNeighbour(neighbor: Neighbor) {
        DUMMY_NeighborS.remove(neighbor)
        _neighbours.value = DUMMY_NeighborS
    }

    override fun createNeighbour(neighbor: Neighbor) {
        DUMMY_NeighborS.add(neighbor)
        _neighbours.value = DUMMY_NeighborS
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        neighbor.favorite = !neighbor.favorite
        _neighbours.value = DUMMY_NeighborS
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
}
