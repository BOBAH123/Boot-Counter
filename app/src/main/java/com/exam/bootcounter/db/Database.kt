package com.exam.bootcounter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exam.bootcounter.BootEvent

@Database(
    entities = [
        BootEvent::class,
    ], version = 1, exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao
}