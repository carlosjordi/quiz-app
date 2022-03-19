package com.carlosjordi.monthlychallenge03.ui.screens.quiz.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosjordi.monthlychallenge03.ui.theme.MonthlyChallenge03Theme

@Composable
fun Timer(
    timer: Float,
    modifier: Modifier = Modifier
) {
    val progress = timer / 30f
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 950,
            easing = LinearEasing
        )
    )
    LinearProgressIndicator(
        progress = animatedProgress,
        modifier = modifier
            .height(16.dp)
    )
}

@Preview(name = "Light Theme Timer", showBackground = true)
@Preview(name = "Dark Theme Timer", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TimerPrev() {
    MonthlyChallenge03Theme {
        Timer(
            timer = 25f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
    }
}