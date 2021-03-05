package com.weesnerdevelopment.neuralNetwork

class Trainer(
    x: Float,
    y: Float,
    val answer: Int
) {
    val inputs = floatArrayOf(x, y, 1f)
}
