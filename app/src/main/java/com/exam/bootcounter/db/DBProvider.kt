package com.exam.bootcounter.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exam.bootcounter.MainApplication

object DBProvider {
    private var roomInstance: Database? = null

    private fun getDb(context: Context): Database {
        if (roomInstance == null) {
            roomInstance = Room.databaseBuilder(
                context, Database::class.java, "Database"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                }).build()
        }

        return roomInstance as Database
    }

    fun getBootEventDao(context: Context = MainApplication.applicationContext()): BootEventDao {
        return getDb(context).bootEventDao()
    }
}