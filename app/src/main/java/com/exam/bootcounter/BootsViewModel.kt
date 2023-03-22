package com.exam.bootcounter

import androidx.lifecycle.ViewModel
import com.exam.bootcounter.db.DBProvider

class BootsViewModel : ViewModel() {
    val bootEventDao = DBProvider.getBootEventDao()

    fun getAllBootEvents() = bootEventDao.getAllBootEventsFlow()
}