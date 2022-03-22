package com.carlosjordi.monthlychallenge03.ui.screens.quiz.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosjordi.monthlychallenge03.ui.theme.MonthlyChallenge03Theme

@Composable
fun Score(
    modifier: Modifier = Modifier,
    score: Int
) {
    Text(
        text = score.toString(),
        fontSize = 32.sp,
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
    )
}

@Preview(name = "Light Theme Score", showBackground = true)
@Preview(name = "Light Theme Score", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScorePrev() {
    MonthlyChallenge03Theme {
        Score(
            score = 27
        )
    }
}