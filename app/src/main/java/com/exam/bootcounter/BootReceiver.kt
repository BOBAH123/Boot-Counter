package com.exam.bootcounter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.exam.bootcounter.db.DBProvider

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {

            val currentTimeMillis = System.currentTimeMillis()
            val bootEvent = BootEvent(time = currentTimeMillis)
            DBProvider.getBootEventDao(context).insertBootEvent(bootEvent)
        }
    }
}