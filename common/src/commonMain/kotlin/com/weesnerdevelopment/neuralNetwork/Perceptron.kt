package com.weesnerdevelopment.neuralNetwork

import kotlin.random.Random

class Perceptron(inputs: Int) {
    private val learningRate = 0.01f
    private val weights = FloatArray(inputs)

    init {
        weights.iterate { index ->
            weights[index] = Random.nextDouble(-1.0, 1.0).toFloat()
        }
    }

    fun feedForward(inputs: FloatArray): Int {
        var sum = 0f
        weights.iterate { index ->
            sum += inputs[index] * weights[index]
        }

        return activate(sum)
    }

    private fun activate(sum: Float): Int {
        return if (sum > 0) 1 else -1
    }

    fun train(inputs: FloatArray, desiredOutput: Int) {
        val guess = feedForward(inputs)
        val error = desiredOutput - guess
        weights.iterate { index ->
            weights[index] += learningRate * error * inputs[index]
        }
    }
}
