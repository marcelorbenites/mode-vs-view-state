package com.marcelorbenites.state

import android.app.Application
import android.content.Intent

class CarApplication: Application() {

    val car: Car by lazy {
        Car(ElectricEngine())
    }

    override fun onCreate() {
        super.onCreate()
        startService(Intent(applicationContext, CarService::class.java))
    }
}