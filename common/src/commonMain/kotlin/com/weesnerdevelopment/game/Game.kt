package com.weesnerdevelopment.game

import androidx.compose.ui.graphics.drawscope.DrawScope

interface Game {
    fun setup() {}
    fun draw(width: Float, height: Float, canvas: DrawScope)
}
