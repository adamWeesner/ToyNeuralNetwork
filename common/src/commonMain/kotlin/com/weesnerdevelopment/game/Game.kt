package com.weesnerdevelopment.game

import androidx.compose.ui.graphics.drawscope.DrawScope

interface Game {
    fun setup() {}
    fun onTouch(x: Float, y: Float) {}
    fun draw(width: Float, height: Float, canvas: DrawScope)
}
