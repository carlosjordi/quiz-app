package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.carlosjordi.monthlychallenge03.R

@Composable
fun QuizScreen(
    viewModel: QuizViewModel
) {
    val state = viewModel.state

    Column {
        Text(text = state.timer.toString())
        Text(text = stringResource(state.currentQuestion.question))
        stringArrayResource(state.currentQuestion.answers).forEach { answer ->
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