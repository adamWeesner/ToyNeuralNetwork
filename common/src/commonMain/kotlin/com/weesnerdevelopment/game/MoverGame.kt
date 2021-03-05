package com.weesnerdevelopment.game

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

class MoverGame : Game {
    private var mover = Mover()

    override fun onTouch(x: Float, y: Float) {
        mover.location.x = x
        mover.location.y = y
    }

    override fun draw(width: Float, height: Float, canvas: DrawScope) {
        mover.move()
        mover.checkEdges(width, height)

        canvas.drawCircle(Color.Black, 32f, Offset(mover.location.x, mover.location.y))
    }
}