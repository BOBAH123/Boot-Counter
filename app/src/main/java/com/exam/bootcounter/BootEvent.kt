package com.exam.bootcounter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_event")
data class BootEvent(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var time: Long
)