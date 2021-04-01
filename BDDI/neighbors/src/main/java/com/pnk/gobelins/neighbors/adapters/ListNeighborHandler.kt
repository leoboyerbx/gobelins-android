package com.pnk.gobelins.neighbors.adapters

import com.pnk.gobelins.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
    fun onLikeNeighbor(neighbor: Neighbor)
    fun onOpenPage(neighbor: Neighbor)
}
