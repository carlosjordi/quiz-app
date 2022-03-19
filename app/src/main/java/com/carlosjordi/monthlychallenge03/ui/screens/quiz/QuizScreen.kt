package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.AnswerOption
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Question
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Timer

@Composable
fun QuizScreen(
    viewModel: QuizViewModel
) {
    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Question(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = stringResource(state.currentQuestion.question)
        )
        Timer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
            timer = state.timer
        )
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
    }
}