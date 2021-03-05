package com.weesnerdevelopment.game

import kotlin.random.Random

class Mover {
    var location: Vector = Vector(
        Random.nextDouble(100.0).toFloat(),
        Random.nextDouble(100.0).toFloat()
    )
    var velocity: Vector = Vector(
        Random.nextDouble(-2.0, 2.0).toFloat(),
        Random.nextDouble(-2.0, 2.0).toFloat()
    )

    fun move() {
        location.plusAssign(velocity)
    }

    fun checkEdges(width: Float, height: Float) {
        if(location.x > width) location.x = 0f
        else if(location.x < 0f) location.x = width

        if(location.y > height) location.y = 0f
        else if(location.y < 0f) location.y = height
    }
}