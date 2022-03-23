package com.carlosjordi.monthlychallenge03.ui.screens.quiz

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.carlosjordi.monthlychallenge03.navigation.Screen
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.AnswerOption
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Question
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Score
import com.carlosjordi.monthlychallenge03.ui.screens.quiz.components.Timer
import kotlinx.coroutines.flow.collect

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state = viewModel.state

    LaunchedEffect(key1 = true) {
        viewModel.navigateToSaveScore.collect { score ->
            navController.navigate(Screen.SaveScore.route + "/$score")
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Question(
                modifier = Modifier
                    .padding(16.dp),
                text = stringResource(state.currentQuestion.question)
            )
            Score(
                modifier = Modifier
                    .padding(end = 16.dp),
                score = state.score.score
            )
        }
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