package com.carlosjordi.monthlychallenge03.ui.screens.quiz.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.carlosjordi.monthlychallenge03.ui.theme.MonthlyChallenge03Theme

@Composable
fun Question(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 20.sp
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = textSize,
        textAlign = TextAlign.Center
    )
}

@Preview(name = "Light Theme Question", showBackground = true)
@Preview(name = "Dark Theme Question", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun QuestionPrev() {
    MonthlyChallenge03Theme {
        Question(text = "¿Quién es iron man?")
    }
}