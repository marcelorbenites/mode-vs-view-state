package com.marcelorbenites.state

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.*

class CarService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    private val car: Car by lazy {
        (applicationContext as CarApplication).car
    }

    private val timer by lazy {
        Timer()
    }

    private val startStopTask by lazy {
        object : TimerTask() {
            override fun run() {
                if (car.isStarted()) {
                    car.stop()
                } else {
                    car.start()
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        timer.schedule(startStopTask, 0, 15000)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
}