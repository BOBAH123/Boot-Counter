package com.exam.bootcounter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[BootsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setText(findViewById<TextView>(R.id.boot_logs))
    }

    private fun setText(view: TextView) {
        viewModel.getAllBootEvents().observe(this) { bootEvents ->

            val text = if (bootEvents.isEmpty()) {
                "No boots detected"
            } else {
                val text = bootEvents.mapIndexed { index, bootEventEntity ->
                    "$index - ${bootEventEntity.time}"
                }.joinToString("\n")
                text
            }
            view.text = text
        }
    }
}