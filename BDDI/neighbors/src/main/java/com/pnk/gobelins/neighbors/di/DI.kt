package com.pnk.gobelins.neighbors.di

import android.app.Application
import com.pnk.gobelins.neighbors.repositories.NeighborRepository

object DI {
    lateinit var repository: NeighborRepository
    fun inject(application: Application) {
        repository = NeighborRepository.getInstance(application)
    }
}
