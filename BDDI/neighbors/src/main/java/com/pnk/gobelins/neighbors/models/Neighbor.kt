package com.pnk.gobelins.neighbors.models

data class Neighbor(
        val id: Int,
        val name: String,
        val avatarUrl: String,
        val address: String,
        val phoneNumber: String,
        val aboutMe: String,
        var favorite: Boolean,
        val webSite: String
)
