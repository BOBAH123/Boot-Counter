package com.exam.bootcounter.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exam.bootcounter.BootEvent

@Dao
interface BootEventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBootEvent(bootEvent: BootEvent): Long

    @Delete
    fun deleteBootEvent(bootEvent: BootEvent)

    @Query("SELECT * FROM boot_event ORDER BY id ASC")
    fun getAllBootEvents(): List<BootEvent>

    @Query("SELECT COUNT(*) FROM boot_event")
    fun getBootEventCount(): Int

    @Query("SELECT * FROM boot_event ORDER BY time ASC")
    fun getAllBootEventsFlow(): LiveData<List<BootEvent>>
}