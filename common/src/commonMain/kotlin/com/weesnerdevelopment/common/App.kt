 package com.weesnerdevelopment.common

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.input.pointer.pointerInput
import com.weesnerdevelopment.game.BouncingBallGame
import com.weesnerdevelopment.game.MoverGame

 @Composable
fun App() {
    //val game = PerceptronTraining()
    //val game = BouncingBallGame()
    val game = MoverGame()

    /**
     * Used to create an animator to cause recomposition on every frame.
     */
    val animatedProgress = animatedFloat(0f)
    onActive {
        animatedProgress.animateTo(
            targetValue = 1f,
            anim = repeatable(
                AnimationConstants.Infinite,
                tween(durationMillis = 1000, easing = LinearEasing)
            )
        )
    }

    MaterialTheme {
        Canvas(modifier = Modifier.fillMaxSize().tapGestureFilter {
            game.onTouch(it.x, it.y)
        }) {
            // this triggers recomposition since it changed
            animatedProgress.value

            game.draw(size.width, size.height, this)
        }
    }
}
