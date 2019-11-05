package com.marcelorbenites.state

class ElectricEngine(private var on: Boolean = false) : Engine {

    override fun turnOn() {
        on = true
    }

    override fun turnOff() {
        on = false
    }

    override fun isTurnedOn() = on
}
