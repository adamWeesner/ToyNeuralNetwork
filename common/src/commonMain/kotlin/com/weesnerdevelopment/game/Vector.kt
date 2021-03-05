package com.weesnerdevelopment.game

import kotlin.math.sqrt

class Vector(
    var x: Float,
    var y: Float
) {
    operator fun plusAssign(other: Vector) {
        x += other.x
        y += other.y
    }

    operator fun plus(other: Vector) = Vector(x + other.x, y + other.y)

    operator fun minusAssign(other: Vector) {
        x -= other.x
        y -= other.y
    }

    operator fun minus(other: Vector) = Vector(x - other.x, y - other.y)

    operator fun timesAssign(n: Float) {
        x *= n
        y *= n
    }

    operator fun times(n: Float) = Vector(x * n, y * n)

    operator fun divAssign(n: Float) {
        x /= n
        y /= n
    }

    operator fun div(n: Float) = Vector(x / n, y / n)

    fun magnitude() = sqrt(x * x + y * y)

    fun normalize(): Vector {
        val magnitude = magnitude()
        return if (magnitude != 0f) div(magnitude) else this
    }
}

fun Float.inBounds(lowerBound: Float, upperBound: Float) =
    this > lowerBound && this < upperBound