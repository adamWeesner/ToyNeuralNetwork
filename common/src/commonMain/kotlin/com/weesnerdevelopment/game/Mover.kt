package com.weesnerdevelopment.game

import kotlin.random.Random

class Mover {
    var location = Vector(
        Random.nextDouble(100.0).toFloat(),
        Random.nextDouble(100.0).toFloat()
    )

    private var velocity = Vector(0f, 0f)
    private val acceleration = Vector(-0.001f, 0.01f)
    private val topSpeed = 50f

    fun move() {
        velocity.plusAssign(acceleration)
        velocity.limit(topSpeed)
        location.plusAssign(velocity)
    }

    fun checkEdges(width: Float, height: Float) {
        if (location.x > width) location.x = 0f
        else if (location.x < 0f) location.x = width

        if (location.y > height) location.y = 0f
        else if (location.y < 0f) location.y = height
    }
}