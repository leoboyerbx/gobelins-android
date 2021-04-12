package com.pnk.gobelins.neighbors.dal.utilis

import com.pnk.gobelins.neighbors.dal.room.entities.NeighborEntity
import com.pnk.gobelins.neighbors.models.Neighbor

fun NeighborEntity.toNeighbor() = Neighbor(
    id = id.toInt(),
    name = name,
    avatarUrl = avatarUrl,
    address = address,
    phoneNumber = phoneNumber,
    aboutMe = aboutMe,
    favorite = favorite,
    webSite = webSite ?: ""
)

fun Neighbor.toEntity() = NeighborEntity(
    id = id.toLong(),
    name = name,
    avatarUrl = avatarUrl,
    address = address,
    phoneNumber = phoneNumber,
    aboutMe = aboutMe,
    favorite = favorite,
    webSite = webSite
)
