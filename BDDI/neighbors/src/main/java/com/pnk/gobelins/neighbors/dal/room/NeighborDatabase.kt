package com.pnk.gobelins.neighbors.dal.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pnk.gobelins.neighbors.dal.memory.DUMMY_NeighborS
import com.pnk.gobelins.neighbors.dal.room.dao.NeighborDao
import com.pnk.gobelins.neighbors.dal.room.entities.NeighborEntity
import com.pnk.gobelins.neighbors.dal.utilis.toEntity
import java.util.concurrent.Executors

@Database(
    entities = [NeighborEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NeighborDataBase : RoomDatabase() {
    abstract fun neighborDao(): NeighborDao

    companion object {
        private var instance: NeighborDataBase? = null
        fun getDataBase(application: Application): NeighborDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    application.applicationContext,
                    NeighborDataBase::class.java,
                    "neighbor_database.db"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        insertFakeData()
                    }
                })
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
        private fun insertFakeData() {
            Executors.newSingleThreadExecutor().execute {
                DUMMY_NeighborS.forEach {
                    instance?.neighborDao()?.add(it.toEntity())
                }
            }
        }
    }
}
