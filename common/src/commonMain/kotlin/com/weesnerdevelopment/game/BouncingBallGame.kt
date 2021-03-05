package com.weesnerdevelopment.game

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

class BouncingBallGame : Game {
    private val location = Vector(100f, 100f)
    private val velocity = Vector(2.5f, 5f)

    override fun draw(width: Float, height: Float, canvas: DrawScope) {
        location += velocity

        if (!location.x.inBounds(0f, width)) velocity.x *= -1
        if (!location.y.inBounds(0f, height)) velocity.y *= -1

        canvas.drawCircle(Color.Black, 32f, Offset(location.x, location.y))
    }
}