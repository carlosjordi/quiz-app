package com.carlosjordi.monthlychallenge03.ui.screens.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.QuizEvent

@Composable
fun AnswerOption(
    answer: String,
    isSelectedOption: Boolean,
    isRightAnswer: Boolean,
    confirmationOccurred: Boolean?,
    onClick: (QuizEvent) -> Unit
) {
    var selectedHighlightColor = if (isSelectedOption) Color.LightGray else Color.Transparent

    confirmationOccurred?.let { rightAnswer ->
        if (isSelectedOption) {
            selectedHighlightColor = if (rightAnswer) {
                Color.Green
            } else Color.Red
        } else if (isRightAnswer) {
            selectedHighlightColor = Color.Green
        }
    }

    Text(
        modifier = Modifier
            .clickable { onClick(QuizEvent.SelectOption(answer)) }
            .background(selectedHighlightColor),
        text = answer
    )
}