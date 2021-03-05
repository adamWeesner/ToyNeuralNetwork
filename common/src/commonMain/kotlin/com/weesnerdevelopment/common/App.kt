 package com.weesnerdevelopment.common

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onActive
import androidx.compose.ui.Modifier
import com.weesnerdevelopment.game.PerceptronTraining

@Composable
fun App() {
    val game = PerceptronTraining()

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
        Canvas(modifier = Modifier.fillMaxSize()) {
            // this triggers recomposition since it changed
            animatedProgress.value

            game.draw(size.width, size.height, this)
        }
    }
}
