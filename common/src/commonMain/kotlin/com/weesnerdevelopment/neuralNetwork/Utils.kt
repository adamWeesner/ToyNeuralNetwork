package com.weesnerdevelopment.neuralNetwork

fun Array<*>.iterate(iteration: (index: Int) -> Unit) {
    for (i in indices) iteration(i)
}

fun FloatArray.iterate(iteration: (index: Int) -> Unit) {
    for (i in indices) iteration(i)

}

/**
 * gives the value of y on the line of the [x] position.
 */
fun f(x: Float) = 2 * x + 1
