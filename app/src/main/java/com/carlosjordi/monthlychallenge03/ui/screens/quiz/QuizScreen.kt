package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.AnswerOption

@Composable
fun QuizScreen(
    viewModel: QuizViewModel
) {
    val state = viewModel.state

    Column {
        Text(text = state.timer.toString())
        Text(text = stringResource(state.currentQuestion.question))
        val answers = stringArrayResource(state.currentQuestion.answers)
        val shuffledAnswers = remember(state.currentQuestion) {
            viewModel.shuffleAnswers(answers)
        }
        shuffledAnswers.forEach { answer ->
            AnswerOption(
                answer = answer,
                isSelectedOption = state.selectedAnswer == answer,
                isRightAnswer = state.rightAnswer == answer,
                confirmationOccurred = state.isRightAnswer,
                onClick = viewModel::onEvent
            )
        }
        if (state.isOptionSelected) {
            Button(onClick = { viewModel.onEvent(QuizEvent.ConfirmSelection) }) {
                Text(text = "Confirm")
            }
        }
    }
}