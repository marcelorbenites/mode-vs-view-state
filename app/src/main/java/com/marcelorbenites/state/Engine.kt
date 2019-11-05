package com.marcelorbenites.state

interface Engine {
    fun turnOn()
    fun turnOff()
    fun isTurnedOn(): Boolean
}
