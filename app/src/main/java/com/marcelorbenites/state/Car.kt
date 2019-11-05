package com.marcelorbenites.state

import java.util.*

class Car(private val engine: Engine): Observable() {

    fun start() {
        engine.turnOn()
        setChanged()
        notifyObservers()
    }

    fun stop() {
        engine.turnOff()
        setChanged()
        notifyObservers()
    }

    fun isStarted() = engine.isTurnedOn()
}