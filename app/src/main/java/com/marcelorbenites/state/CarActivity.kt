package com.marcelorbenites.state

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_car.*
import java.util.*

class CarActivity : AppCompatActivity() {

    private val car: Car by lazy {
        (applicationContext as CarApplication).car
    }

    private val carObserver by lazy {
        Observer { _, _ ->
            runOnUiThread {
                updateView()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)
        car.addObserver(carObserver)
        saveButton.setOnClickListener {
            if (car.isStarted()) {
                car.stop()
            } else {
                car.start()
            }
        }
    }

    override fun onDestroy() {
        saveButton.setOnClickListener(null)
        car.deleteObserver(carObserver)
        super.onDestroy()
    }

    private fun updateView() {
        startedSwitch.isChecked = car.isStarted()
    }
}