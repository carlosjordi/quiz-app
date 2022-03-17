package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource

@Composable
fun QuizScreen(
    viewModel: QuizViewModel
) {
    val state = viewModel.state

    Column {
        Text(text = state.timer.toString())
        Text(text = stringResource(state.currentQuestion.question))
        val answers = stringArrayResource(state.currentQuestion.answers)
        viewModel.saveRightAnswer(answers[0])
        val shuffledAnswers = remember(state.currentQuestion) {
            answers.toMutableList().shuffled()
        }
        shuffledAnswers.forEach { answer ->
            Text(
                modifier = Modifier
                    .clickable { viewModel.onEvent(QuizEvent.SelectOption(answer)) },
                text = answer
            )
        }
        if (state.isOptionSelected) {
            Button(onClick = { viewModel.onEvent(QuizEvent.ConfirmSelection) }) {
                Text(text = "Confirm")
            }
        }
    }
}