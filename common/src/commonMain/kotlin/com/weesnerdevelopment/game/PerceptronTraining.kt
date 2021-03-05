package com.weesnerdevelopment.game

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.weesnerdevelopment.neuralNetwork.Perceptron
import com.weesnerdevelopment.neuralNetwork.Trainer
import com.weesnerdevelopment.neuralNetwork.f
import com.weesnerdevelopment.neuralNetwork.iterate
import kotlin.random.Random

class PerceptronTraining : Game {
    private var count: Int = 0
    private val perceptron = Perceptron(3)
    private val training = Array(2000) { Trainer(0f, 0f, 0) }

    override fun draw(width: Float, height: Float, canvas: DrawScope) {
        training.iterate { index ->
            val x = Random.nextDouble(width.toDouble()).toFloat()
            val y = Random.nextDouble(height.toDouble()).toFloat()
            val answer = if (y > f(x)) -1 else 1

            training[index] = Trainer(x, y, answer)
        }

        perceptron.train(training[count].inputs, training[count].answer)
        count = (count + 1) % training.size

        println("scope ran $count")

        for (i in 0 until count) {
            val guess = perceptron.feedForward(training[i].inputs)
            val countX = training[i].inputs[0]
            val countY = training[i].inputs[1]
            val color = if (guess > 0) Color.Black else Color.Red

            canvas.drawCircle(color, 8f, Offset(countX, countY))
        }
    }
}