package com.pnk.gobelins.neighbors.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pnk.gobelins.neighbors.di.DI
import com.pnk.gobelins.neighbors.models.Neighbor
import com.pnk.gobelins.neighbors.repositories.NeighborRepository

class NeighborViewModel : ViewModel() {
    private val repository: NeighborRepository = DI.repository

    val neighbors: LiveData<List<Neighbor>>
        get() = repository.getNeighbours()
}
